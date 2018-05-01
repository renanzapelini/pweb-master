package controller;

import java.io.File;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

//import com.sun.faces.facelets.util.Path;

import business.AlunoBusiness;
import model.Aluninho;
import model.Aluno;

@ViewScoped
@ManagedBean(name="aluninhoController")
public class AluninhoController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Aluno aluno;

	private List<Aluninho> alunos = new ArrayList<>();

	private AlunoBusiness alunoBusiness;

	@PostConstruct
	public void initialize() {
		novoAluno();
		alunoBusiness = new AlunoBusiness();
	}

	public void editar(ActionEvent event) {
		setAluno((Aluno) event.getComponent().getAttributes().get("alunoSelecionado"));
	}

	public void excluir(ActionEvent event) {
		alunos.remove((Aluno) event.getComponent().getAttributes().get("alunoExcluido"));
	}

	public void salvar() {

	}

	public void upload(FileUploadEvent ev) {
		try {
		//	UploadedFile uploadedFile = ev.getFile();
		//	File file = new File("c:\\uploads",uploadedFile.getFileName());
			
		//	OutputStream out = new FileOutputStream(file);
		//	out.write(uploadedFile.getContents());
		//	out.close();
			
			UploadedFile  x = ev.getFile();
			Path t = Files.createTempFile(null,null);
			Files.copy(x.getInputstream(), t, StandardCopyOption.REPLACE_EXISTING);
			
			Path origem =  Paths.get(t.toString());
			Path destino =  Paths.get("C:\\uploads\\" + x.getFileName());
			
			System.out.println(t.toString());
			
			Files.copy(origem, destino, StandardCopyOption.REPLACE_EXISTING);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void novoAluno() {
		aluno = new Aluno();
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Aluninho> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluninho> alunos) {
		this.alunos = alunos;
	}

}
