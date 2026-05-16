public class Pizza {
    
    public enum Tamanho{
		Familia,
		Grande,
		Media,
		Pequena
	}
	public enum Sabor {
		Calabresa,
		Frango,
		QuatroQueijos,
		Portuguesa
	}
	
	private Tamanho tamanho;
    private Sabor sabor;
    private Boolean comBorda;
    
	public Tamanho getTamanho() {
		return tamanho;
	}
	public void setTamanho(Tamanho tamanho) {
		this.tamanho = tamanho;
	}
	public Sabor getSabor() {
		return sabor;
	}
	public void setSabor(Sabor sabor) {
		this.sabor = sabor;
	}
	public Boolean getComBorda() {
		return comBorda;
	}
	public void setComBorda(Boolean comBorda) {
		this.comBorda = comBorda;
	}
	
	@Override
	public String toString() {
		return "Pizza [tamanho=" + tamanho + ", sabor=" + sabor + ", comBorda=" + comBorda + "]";
	}
}
