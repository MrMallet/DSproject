package ie.gmit.sw;

public class Request {
		private String cypherText;
		private int maxKeySize;
		private long jobNumber;
		
		public Request(String cypherText, int maxKeySize, long jobNumber) {
			setCypherText(cypherText);
			setMaxKeySize(maxKeySize);
			setJobNumber(jobNumber);
		}
		
		public String getCypherText() {
			return cypherText;
		}
		public void setCypherText(String cypherText) {
			this.cypherText = cypherText;
		}
		public int getMaxKeySize() {
			return maxKeySize;
		}
		public void setMaxKeySize(int maxKeySize) {
			this.maxKeySize = maxKeySize;
		}
		public long getJobNumber() {
			return jobNumber;
		}
		public void setJobNumber(long jobNumber) {
			this.jobNumber = jobNumber;
		}
		
		//constructors and getters/setters;
}
