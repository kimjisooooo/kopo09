package kr.ac.kopo09.ctc.spring.board.web;

import kr.ac.kopo09.ctc.spring.board.domain.Sosick;
import kr.ac.kopo09.ctc.spring.board.domain.Sosick_Comment;
import kr.ac.kopo09.ctc.spring.board.domain.User;
import kr.ac.kopo09.ctc.spring.board.dto.SosickCommentDto;
import kr.ac.kopo09.ctc.spring.board.repository.SosickRepository;
import kr.ac.kopo09.ctc.spring.board.repository.Sosick_CommentRepository;
import kr.ac.kopo09.ctc.spring.board.repository.UserRepository;
import kr.ac.kopo09.ctc.spring.board.service.SosickService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
public class SosickController {

	@Autowired
	private SosickService sosickService;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SosickRepository sosickRepository;
	
	@Autowired
	private Sosick_CommentRepository sosick_CommentRepository;
	
	@GetMapping("/list")
	public String list(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "searchType", required = false) String searchType,
			@RequestParam(value = "keyword", required = false) String keyword, Model model) {
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

	@RequestMapping("/view/{id}")
	public String view(@PathVariable Long id, Model model) {
		int newid = (int) (long) id;
		Sosick sosickEntity = sosickService.selectOne(newid);
		List<SosickCommentDto> sosickCommentDto = sosickService.getSosickCommentDtosBySosickId(id);
//        for(int i = 0; i<sosickCommentDto.size(); i++) {
//        	System.out.println("댓글: " + sosickCommentDto.get(i).getContent());
//        }
		model.addAttribute("id", id);
		model.addAttribute("sosickEntity", sosickEntity);
		model.addAttribute("sosickCommentDto", sosickCommentDto);
//        model.addAttribute("comments", comments);
		return "/board/sosick_view";
	}

	
	@RequestMapping("/comment_to_board")
	public String addCommentOrReply(@RequestParam(name = "articleid") Long articleId,
			@RequestParam(name = "id", required = false) Long userId,
			@RequestParam(name = "parentCommentId", required = false) Long parentCommentId,
			@RequestParam(name = "title") String content, RedirectAttributes rttr) {
		System.out.println(articleId);
		System.out.println(userId);
		System.out.println(parentCommentId);
		
		if (userId == null) {
			rttr.addFlashAttribute("Message", "사용자 ID가 필요합니다.");
			return "redirect:/boards?id=" + articleId;
		}
		User userItem = userRepository.findById(userId).orElse(null);
		if (userItem == null) {
			rttr.addFlashAttribute("Message", "존재하지 않는 사용자입니다.");
			return "redirect:/boards?id=" + articleId;
		}
		Sosick boardItem = sosickRepository.findById(articleId).orElse(null);
		if (boardItem == null) {
			rttr.addFlashAttribute("Message", "존재하지 않는 게시물입니다.");
			return "redirect:/boards?id=" + articleId;
		}
		Sosick_Comment newComment = new Sosick_Comment();
		newComment.setContent(content);
		newComment.setUser(userItem);
		newComment.setSosick(boardItem);
		log.info("articleId: {}", articleId);
		log.info("userId: {}", userId);
		log.info("parentCommentId: {}", parentCommentId);
		if (parentCommentId != null) {
	// 대댓글인 경우
			Sosick_Comment parentComment = sosick_CommentRepository.findById(parentCommentId).orElse(null);
			if (parentComment != null) {
				newComment.setParentComment(parentComment);
			} else {
				rttr.addFlashAttribute("Message", "존재하지 않는 부모 댓글입니다.");
				return "redirect:/boards?id=" + articleId;
			}
		}
		sosick_CommentRepository.save(newComment);
		return "redirect:/boards?id=" + articleId;
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

}
