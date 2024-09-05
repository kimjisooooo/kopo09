package kr.ac.kopo09.ctc.spring.board.web;

import kr.ac.kopo09.ctc.spring.board.domain.Sosick;
import kr.ac.kopo09.ctc.spring.board.domain.Sosick_Comment;
import kr.ac.kopo09.ctc.spring.board.service.SosickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class SosickController {

    @Autowired
    private SosickService sosickService;

    @GetMapping("/list")
    public String list(@RequestParam(value = "page", defaultValue = "1") int page,
                       @RequestParam(value = "searchType", required = false) String searchType,
                       @RequestParam(value = "keyword", required = false) String keyword,
                       Model model) {
        List<Sosick> items = sosickService.getPagination(page, 10, searchType, keyword);
        int totalCount = sosickService.count(searchType, keyword);
        int sizePerPage = 10;
        int totalPage = (int) Math.ceil((double) totalCount / sizePerPage);
        int startPage = ((page - 1) / sizePerPage) * sizePerPage + 1;
        int endPage = Math.min(startPage + sizePerPage - 1, totalPage);
        int nextPageGroup = page + sizePerPage;
        int prevPageGroup = page - sizePerPage;
        System.out.println(totalPage);
        System.out.println(nextPageGroup); 
        System.out.println(endPage); 
        model.addAttribute("items", items);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("nextPageGroup", nextPageGroup);
        model.addAttribute("prevPageGroup", prevPageGroup);
        model.addAttribute("searchType", searchType);
        model.addAttribute("keyword", keyword);
        return "/board/sosick_list";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {
        Sosick sosickEntity = sosickService.selectOne(id);
        List<Sosick_Comment> comments = sosickService.getComments(id);
        model.addAttribute("sosickEntity", sosickEntity);
        model.addAttribute("comments", comments);
        return "/board/sosick_view";
    }

    @GetMapping("/sosick/new")
    public String createForm(Model model) {
        model.addAttribute("sosickEntity", new Sosick());
        return "/sosick/new";
    }

    @PostMapping("/sosick/new")
    public String create(@ModelAttribute Sosick sosickEntity, Model model) {
        if (sosickEntity.getTitle().isEmpty() || sosickEntity.getContent().isEmpty()) {
            model.addAttribute("errorMessage", "모든 필드를 입력해야 합니다.");
            return "/sosick/new";
        }

        sosickEntity.setDate(new Date());
        sosickService.create(sosickEntity.getTitle(), sosickEntity.getContent(), sosickEntity.getDate());
        return "redirect:/sosick/list";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable int id, Model model) {
        Sosick sosickEntity = sosickService.selectOne(id);
        model.addAttribute("sosickEntity", sosickEntity);
        return "redirect:/sosick_update";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable int id, @ModelAttribute Sosick sosickEntity, Model model) {
        if (sosickEntity.getTitle().isEmpty() || sosickEntity.getContent().isEmpty()) {
            model.addAttribute("errorMessage", "모든 필드를 입력해야 합니다.");
            model.addAttribute("sosickEntity", sosickEntity);
            return "redirect:/sosick_update";
        }

        sosickService.update(id, sosickEntity.getTitle(), sosickEntity.getContent(), new Date());
        return "redirect:/sosick/list";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        sosickService.delete(id);
        return "redirect:/sosick/list";
    }

    @PostMapping("/comment/{sosickId}")
    public String addComment(@PathVariable int sosickId, @RequestParam String content) {
        sosickService.addComment(sosickId, content);
        return "redirect:/sosick/view/" + sosickId;
    }

    @PostMapping("/comment/delete/{commentId}")
    public String deleteComment(@PathVariable int commentId, @RequestParam int sosickId) {
        sosickService.deleteComment(commentId);
        return "redirect:/sosick/view/" + sosickId;
    }
}
