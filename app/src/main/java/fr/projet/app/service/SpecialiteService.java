package fr.projet.app.service;

import fr.projet.app.model.Specialite;
import fr.projet.app.repository.SpecialiteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class SpecialiteService
{
	private SpecialiteRepository specialiteRepository;

	public SpecialiteService(SpecialiteRepository specialiteRepository)
	{
		this.specialiteRepository = specialiteRepository;
	}
	
	
	@Transactional
	public Specialite createSpecialite(Specialite specialite)
	{
		Optional<Specialite> optionalSpl = specialiteRepository.findAll().stream().filter(s -> s.equals(specialite)).findFirst();		
		if(optionalSpl.isPresent())
		{
			Specialite existSpl = optionalSpl.get();
			if(existSpl != null) return existSpl;
			else return specialiteRepository.save(specialite);
		}
		else
		{
			return specialiteRepository.save(specialite);
		}
	}
	
	
	
	@Transactional
	public Specialite updateSpecialite(Specialite oldSpl, Specialite newSpl)
	{
		if(oldSpl.getEducations().size() <= 1)
		{
			this.deleteSpecialite(oldSpl.getIdSpecialite());			
		}
		Optional<Specialite> optionalSpl = specialiteRepository.findAll().stream().filter(s -> s.equals(newSpl)).findFirst();
		if(optionalSpl.isPresent())
		{
			Specialite existSpl = optionalSpl.get();
			if(existSpl != null) return existSpl;
		}
		return specialiteRepository.save(newSpl);
	}

	

	public void deleteSpecialite(int idSpecialite)
	{
		specialiteRepository.deleteById(idSpecialite);
		System.out.println("idSpl deleted : "+idSpecialite);
	}
	
	public Optional<Specialite> findSpecialiteById(int idSpecialite)
	{
		return specialiteRepository.findById(idSpecialite);
	}
	
}
	

