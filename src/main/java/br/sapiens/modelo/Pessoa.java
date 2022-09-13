package br.sapiens.modelo;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pessoa {
    private String nome;
    private String sobreNome;

    public void setNome(String nome) throws Exception {
        if(this.validaSeStringVazia(nome))
            throw new Exception("valor é inválido");

        this.nome = nome;
    }

    public boolean validaSeStringVazia(String texto)
    {
        return texto == null || texto.isEmpty();
    }

    private String email;
    private ProfissaoEnum profissao;

    private List<Disciplina> disciplinas;
    private boolean bolsa;

    public Pessoa(String nome, String sobreNome, String email) throws Exception {
        this.setNome(nome);
        this.setSobreNome(sobreNome);
        this.setEmail(email);
        this.profissao = ProfissaoEnum.Nenhum;
    }

    private void setSobreNome(String sobreNome) throws Exception {
        if(this.validaSeStringVazia(sobreNome))
            throw new Exception("valor é inválido");

        this.sobreNome = sobreNome;
    }

    public String getNome() {
        return nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public String getEmail() {
        return email;
    }

    public ProfissaoEnum getProfissao() {
        return profissao;
    }

    public void setProfissao(ProfissaoEnum profissao) {
        this.profissao = profissao;
    }
    public void setEmail(String email) throws Exception {
        if (!this.isValidEmailAddressRegex(email)) {
            throw new Exception("email é inválido");
        }

        this.email = email;
    }

    public static boolean isValidEmailAddressRegex(String email) {
        boolean isEmailIdValid = false;
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                isEmailIdValid = true;
            }
        }
        return isEmailIdValid;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    @Override
    public String toString() {
        return nome+" "+sobreNome+" | "+email;
    }

    public boolean getBolsa() {
        return true;
    }

    public void setBolsa(boolean b) {
        this.bolsa = b;
    }

    public CursosEnum getCurso() {
        return null;
    }
}
