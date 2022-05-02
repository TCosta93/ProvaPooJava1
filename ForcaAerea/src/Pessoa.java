
    public abstract class Pessoa {
        private String _nome;
        private String _cpf;
    
        protected Pessoa(String nome, String cpf) {
            _nome = nome;
            _cpf = cpf;
        }
    
        public String getNome() {
            return _nome;
        }
    
        public String getCpf() {
            return _cpf;
        }
    
        public abstract String getTipo();
    
        @Override
        public String toString() {
            return getTipo() + "Nome Completo: " + _nome + ", CPF: " + _cpf;
        }
    }  

