
    public class Piloto extends Pessoa {
        private String _cht;
    
    
        public Piloto(String nome, String cht, String cpf) {
            super(nome, cpf);
    
            _cht = cht;
        }
    
        public String getCnh() {
            return _cht;
        }
    
        @Override
        public String toString() {
            return super.toString() + " , Carteira de Piloto Privado: " + _cht;
        }
    
        @Override
        public String getTipo() {
            return "Piloto: ";
        }

    }

