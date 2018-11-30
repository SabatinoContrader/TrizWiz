package main.model;

public class Depri {
	private int id;
	private int pricId;
	private int exld;

		public Depri (int id, int pricId,int exld) {
			this.id=id;
			this.pricId=pricId;
			this.exld=exld;
			
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getPricId() {
			return pricId;
		}

		public void setPricId(int pricId) {
			this.pricId = pricId;
		}

		public int getExld() {
			return exld;
		}

		public void setExld(int exld) {
			this.exld = exld;
		}			
}

