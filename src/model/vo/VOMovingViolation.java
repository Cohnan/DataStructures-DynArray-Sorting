package model.vo;

import java.util.Calendar;

/**
 * Representation of a MovingViolation object
 */
public class VOMovingViolation implements Comparable<VOMovingViolation> {

	public static final String[] EXPECTEDHEADERS = new String[] {"OBJECTID", "ROW_", "LOCATION", "ADDRESS_ID", "STREETSEGID", "XCOORD", "YCOORD", "TICKETTYPE", "FINEAMT", "TOTALPAID", "PENALTY1", "PENALTY2", "ACCIDENTINDICATOR", "AGENCYID", "TICKETISSUEDATE", "VIOLATIONCODE", "VIOLATIONDESC", "ROW_ID"};
	// Estos son los indice de los textos en EXPECTEDHEADERS
		public static final int OBJECTID = 0;
		public static final int ROW_= 1;
		public static final int LOCATION = 2;
		public static final int ADDRESS_ID = 3;
		public static final int STREETSEGID = 4;
		public static final int XCOORD = 5;
		public static final int YCOORD = 6;
		public static final int TICKETTYPE = 7;
		public static final int FINEAMT = 8;
		public static final int TOTALPAID = 9;
		public static final int PENALTY1 = 10;
		public static final int PENALTY2 = 11;
		public static final int ACCIDENTINDICATOR = 12;
		public static final int AGENCYID = 13;
		public static final int TICKETISSUEDATE = 14;
		public static final int VIOLATIONCODE = 15;
		public static final int VIOLATIONDESC = 16;	
		public static final int ROW_ID = 17;
	
	/**
	 * Atributos de la infracci�n
	 */
	private int iD; 
	private String location;
	private int addressID;
	private int streetsegID;
	private double totalPaid;
	private double penalty1;
	private double penalty2;
	private boolean accidentIndicator;
	private Calendar ticketIssueDate;
	private String violationCode;
	private String violationDesc;
	private int fineAmount;


	/**
	 * Constructor. Recibe los argumentos de la infracci�n a trav�s del archivo CSV
	 */
	public VOMovingViolation(int[] headerPositions, String[] linea){
		String campo;
		
		iD = Integer.parseInt(linea[0]); //linea[headerPositions[OBJECTID]];
		
		location = linea[headerPositions[LOCATION]];
		
		campo = linea[headerPositions[ADDRESS_ID]];
		if (!campo.equals("")) addressID = Integer.parseInt(campo);
		else addressID = -1;
		
		campo = linea[headerPositions[STREETSEGID]];
		if (!campo.equals("")) streetsegID = Integer.parseInt(campo);
		else streetsegID = -1;
		
		totalPaid = Double.parseDouble(linea[headerPositions[TOTALPAID]]);
		
		campo = linea[headerPositions[PENALTY1]];
		if (!campo.equals("")) penalty1 = Double.parseDouble(campo);
		else penalty1 = 0;
		
		campo = linea[headerPositions[PENALTY2]];
		if (!campo.equals("")) penalty2 = Double.parseDouble(campo);
		else penalty2 = 0;
		
		campo = linea[headerPositions[ACCIDENTINDICATOR]];
		if 		(campo.equalsIgnoreCase("Yes")) accidentIndicator = true;
		else if (campo.equalsIgnoreCase("No"))	accidentIndicator = false;
		else throw new IllegalArgumentException("El indicador de accidente no tiene un valor reconocible.");
		
		campo = linea[headerPositions[TICKETISSUEDATE]];
		ticketIssueDate = Calendar.getInstance();
		ticketIssueDate.set(Integer.parseInt(campo.substring(0, 4)), Integer.parseInt(campo.substring(5, 7)), Integer.parseInt(campo.substring(8,10)),Integer.parseInt(campo.substring(11,13)),Integer.parseInt(campo.substring(14,16)));
		
		violationCode = linea[headerPositions[VIOLATIONCODE]];
		
		violationDesc = linea[headerPositions[VIOLATIONDESC]];
		
		fineAmount = Integer.parseInt(linea[headerPositions[FINEAMT]]);
	}
	

	
	/**
	 * @return id - Identificador unico de la infraccion
	 */
	public int objectId() {
		return iD;
	}	
	
	
	/**
	 * @return location - Direccion en formato de texto.
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @return date - Fecha cuando se puso la infraccion .
	 */
	public Calendar getTicketIssueDate() {
		return ticketIssueDate;
	}
	
	/**
	 * @return totalPaid - Cuanto dinero efectivamente paga el que recibio la infraccion en USD.
	 */
	public int getTotalPaid() {
		return (int) totalPaid;
	}
	
	/**
	 * @return accidentIndicator - Si hubo un accidente o no.
	 */
	public boolean  getAccidentIndicator() {
		return accidentIndicator;
	}
		
	/**
	 * @return description - Descripcion textual de la infraccion.
	 */
	public String  getViolationDescription() {
		return violationDesc;
	}

	@Override
	public int compareTo(VOMovingViolation infraccion2) {
	
		if(ticketIssueDate.compareTo(infraccion2.getTicketIssueDate())>0){
			return 1;
		}
		if(ticketIssueDate.compareTo(infraccion2.getTicketIssueDate())<0){
			return -1;
		}
		if (objectId()>infraccion2.objectId()){
			return 1;
		}
		if (objectId()<infraccion2.objectId()){
			return -1;
		}
		return 0;
		
		
	}
	
	public String toString()
	{
		return "ID: " + iD + ", Ticket Issue Data: " + ticketIssueDate.get(Calendar.DAY_OF_MONTH) + "/" + ticketIssueDate.get(Calendar.MONTH) + " at " + ticketIssueDate.getActualMaximum(Calendar.HOUR) + ":" + ticketIssueDate.get(Calendar.MINUTE) ;
	}
}
