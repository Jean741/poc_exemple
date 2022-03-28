package tn.altenders.poc.exception;
 public class EntitieNotFoundException extends Exception {
 
	private static final long serialVersionUID = -2092151857800687364L;

		public EntitieNotFoundException() {
            super("Entitie not found in DataDase");
        }

        public EntitieNotFoundException(String message) {
            super("Entitie not found in DataDase: " + message);
        }
    }