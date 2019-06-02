package fatec.poo.model;

/**
 * @author 0030481711036
 * @author 0030481721015
 */

public class Pessoa {
    
    private String cpf;
    private String nome;
    private String endereco;
    private String cidade;
    private String uf;
    private String cep;
    private String ddd;
    private String telefone;

    public Pessoa(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }
    
    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public static boolean validarCpf(String cpf) {
        String Caracter = null;
        int Digito1 = 0, Digito2 = 0, k = 0;

        if (cpf == null || cpf.length() < 11)
            return false;
        else
        {
            for (int i = 0; i < 9; i++)
            {
                Caracter = cpf.substring(i, 1);
                if (Caracter == cpf.substring(i + 1, 1))
                    k++;
            }
            if (k == 9)
                return false;
            else
            {
                for (int i = 0; i < 9; i++)
                {
                    Caracter = cpf.substring(i, 1);
                    Digito1 += Integer.parseInt(Caracter) * (10 - i);
                    Digito2 += Integer.parseInt(Caracter) * (11 - i);
                }
                Digito1 = (Digito1 * 10) % 11;
                Digito2 = ((Digito2 + (Digito1 * 2)) * 10) % 11;

                if (Digito1 == 10)
                    Digito1 = 0;

                if (Digito2 == 10)
                    Digito2 = 0;

                if (Digito1 == Integer.parseInt(cpf.substring(9, 1)) && Digito2 == Integer.parseInt(cpf.substring(10, 1)))
                    return true;
                else
                    return false;
            }
        }
    }
}
