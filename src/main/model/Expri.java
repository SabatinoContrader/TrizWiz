package main.model;


public class Expri {
		private int id;
		private String commento;
 //costruttore
		public Expri (int id, String commento) {
		this.id=id;
		this.commento=commento;

}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getCommento() {
			return commento;
		}

		public void setCommento(String commento) {
			this.commento = commento;
		}
}