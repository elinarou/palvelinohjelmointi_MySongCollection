package s22.mySongCollection.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import s22.mySongCollection.domain.Song;
import s22.mySongCollection.domain.SongRepository;
import s22.mySongCollection.domain.GenreRepository;
import s22.mySongCollection.domain.InstrumentRepository;

@Controller
public class SongController {
	
	@Autowired
	private SongRepository repository;
	
	@Autowired
	private GenreRepository grepository;
	
	@Autowired
	private InstrumentRepository irepository;
	
	// Show songlist
	@RequestMapping(value= {"/", "/index"})
	public String songlist(Model model) {
		model.addAttribute("songs", repository.findAll());
		return "index";
	}
	
	// Add new song
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/addsong")
	public String addSong(Model model){
		model.addAttribute("song", new Song());
		model.addAttribute("genres", grepository.findAll());
		model.addAttribute("instruments", irepository.findAll());
		return "addsong";
	}
	
	// Save new song
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid Song song, BindingResult bindingResult, Model model){
		if (bindingResult.hasErrors()) {
			System.out.println("Some error happened.");
			model.addAttribute("genres", grepository.findAll());
			model.addAttribute("instruments", irepository.findAll());
			return "addsong";
		}
		repository.save(song);
		return "redirect:index";
	}
	
	// Delete song
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteSong(@PathVariable("id") Long songId, Model model){ 
		repository.deleteById(songId);
		return "redirect:../index";
	}
	
	// Edit song
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/editsong/{id}", method = RequestMethod.GET)
	public String editSong(@Valid Song song, BindingResult bindingResult, @PathVariable("id") Long songId, Model model){ 
		model.addAttribute("song", repository.findById(songId));
		model.addAttribute("genres", grepository.findAll());
		model.addAttribute("instruments", irepository.findAll());
		return "editsong";
	}
 
}