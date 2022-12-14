package fr.projet.app.service;

import fr.projet.app.model.Diplome;
import fr.projet.app.repository.DiplomeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class DiplomeService 
{
	private DiplomeRepository diplomeRepository;

	public DiplomeService(DiplomeRepository diplomeRepository)
	{
		this.diplomeRepository = diplomeRepository;
	}
	
	
	@Transactional
	public Diplome createDiplome(Diplome diplome)
	{
		Optional<Diplome> optionalDpl = diplomeRepository.findAll().stream().filter(d -> d.equals(diplome)).findFirst();
		if(optionalDpl.isPresent())
		{
			Diplome existDpl = optionalDpl.get();
			if(existDpl != null) return existDpl;
			else return diplomeRepository.save(diplome);
		}
		else
		{
			return diplomeRepository.save(diplome);			
		}
	}
	
	
	@Transactional
	public Diplome updateDiplome(Diplome oldDpl, Diplome newDpl)
	{
		if(oldDpl.getEducations().size() <= 1) 
		{
			this.deleteDiplome(oldDpl.getIdDiplome());			
		}
		Optional<Diplome> optionalDpl = diplomeRepository.findAll().stream().filter(d -> d.equals(newDpl)).findFirst();
		if(optionalDpl.isPresent())
		{
			Diplome existDpl = optionalDpl.get();
			if(existDpl != null) return existDpl;
		}
		return diplomeRepository.save(newDpl);		
	}
	
	
	public void deleteDiplome(int idDiplome) 
	{
		diplomeRepository.deleteById(idDiplome);
		System.out.println("idDpl deleted : "+idDiplome);
	}
	
	public Optional<Diplome> findDiplomeById(int idDiplome)
	{
		return diplomeRepository.findById(idDiplome);
	}
	
}
	