package fr.projet.app.model;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="education")
public class Education 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_edc")
	private int IdEducation;
	
	@Column(name="recu_edc")
	private Boolean recu;

	@Column(name="lieu_edc", length=50)
	@Length(max=50)
	private String lieu;

	@Column(name="ecole_edc", length=50)
	@Length(max=50)
	private String ecole;
	
	@Column(name="debut_edc")
	private Date debut;	

	@Column(name="fin_edc")
	private Date fin;

	@Column(name="info_edc", length=500)
	@Length(max=500)
	private String info;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cdt")
	@JsonIgnore
	private Candidat candidat;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_spl")
	private Specialite specialite;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_dpl")
	private Diplome diplome;

	public int getIdEducation() {
		return IdEducation;
	}

	public Boolean getRecu() {
		return recu;
	}

	public String getLieu() {
		return lieu;
	}

	public String getEcole() {
		return ecole;
	}

	public Date getDebut() {
		return debut;
	}

	public Date getFin() {
		return fin;
	}

	public String getInfo() {
		return info;
	}

	public Candidat getCandidat() {
		return candidat;
	}
	
	public Specialite getSpecialite() {
		return specialite;
	}

	public Diplome getDiplome() {
		return diplome;
	}

	public void setRecu(Boolean recu) {
		this.recu = recu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public void setEcole(String ecole) {
		this.ecole = ecole;
	}

	public void setDebut(Date debut) {
		this.debut = debut;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public void setCandidat(Candidat candidat) {
		this.candidat = candidat;
	}
	
	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}

	public void setDiplome(Diplome diplome) {
		this.diplome = diplome;
	}
}
