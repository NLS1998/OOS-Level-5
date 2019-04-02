package auctions;

public class Status {
	
	private enum Stat {
		PENDING,
		ACTIVE,
		CLOSED,
	}

	private enum stat {
		PENDING("PENDING"), ACTIVE("ACTIVE"), CLOSED("CLOSED");
		private String status;
		private stat(String Status) {
			this.status = Status;
		}
		
		public String toString() {
			return status;
		}
	}
	}





