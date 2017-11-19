/** Defines a class of School objects that store information about individual grad schools
  * @author Takis Metaxas
  * KNOWN BUGS: 
  * 1. Enforces ratings in the range [1..10] by limiting larger/smaller values
  * but only for academics, research, pubs. 
  * 2. Having the overallRating and rankValue included in this class is not the best approach,
  * because it reveals knowledge on how Schools will be used in a particular application.
  * Better create class RankedSchool extending School, and have them in there.
  */
public class School {  
  
  // instance variables 
  
  // ratings are assumed to be an integer from 1 to 10
  final int MIN = 1;
  final int MAX = 10;
  
  private String name;         // name of school
  private int rateAcademics;   // rating of Academics  
  private int rateResearch;    // rating of educating research scholars 
  private int ratePubs;        // rating of impact of faculty publications
  private int overallRating;   // overall rating that uses all factors
  private int rankValue;       // value used to rank schools, based on one
  // factor or all factors combined
  
  /** Initializes a school object, and enforces all values to be within MIN and MAX.
    * @param name The school name
    * @param academics Rating of academics 
    * @param research Rating of educating research scholars 
    * @param pubs Rating of impact of faculty publications 
    */
  public School (String name, int academics, int research, int pubs) {
    this.name = name; 
    // ratings are assumed to be an integer from MIN to MAX
    rateAcademics = (academics > MAX)? MAX : academics; 
    rateAcademics = (academics < MIN)? MIN : rateAcademics; // do you see why?
    rateResearch = (research > MAX)? MAX : research; 
    rateResearch = (research < MIN)? MIN : rateResearch; 
    ratePubs = (pubs > MAX)? MAX : pubs;
    ratePubs = (pubs < MIN)? MIN : ratePubs;
    overallRating = 0;
    rankValue = 0;
  }
  
  // Getters and setters for each instance variable (when appropriate)
  /**
   * Gets the school name.
   * @return The school name
   */
  public String getName () {
    return name;
  }
  
  /**
   * Sets a value to the school name.
   * @param newName The new school name
   */
  public void setName (String newName) {
    name = newName;
  }
  
   /**
   * Gets the acedmics rating.
   * @return The academics rating
   */
  public int getRateAcademics () {
    return rateAcademics;
  }
  
   /**
   * Sets a value to the academics rating.
   * @param newRate The academics rating
   */
  public void setRateAcademics (int newRate) {
    rateAcademics = newRate;
  }
  
  /**
   * Gets the research rating.
   * @return The research rating
   */
  public int getRateResearch () {
    return rateResearch;
  }
  
     /**
   * Sets a value to the research rating.
   * @param newRate The research rating
   */
  public void setRateResearch (int newRate) {
    rateResearch = newRate;
  }
  
  /**
   * Gets the publications rating.
   * @return The publications rating
   */
  public int getRatePubs () {
    return ratePubs;
  }
  
   /**
   * Sets a value to the publications rating.
   * @param newRate The publications rating
   */
  public void setRatePubs (int newRate) {
    ratePubs = newRate;
  }
  
  /**
   * Gets the school's ranking value.
   * @return The rank
   */
  public int getRankValue () {
    return rankValue;
  }
  
   /**
   * Sets a value to the school rank.
   * @param newValue The school rank
   */
  public void setRankValue (int newValue) {
    rankValue = newValue;
  }
  
  /**
   * Gets the overall rating of the school.
   * @return The overall rating
   */
  public int getOverallRating () {
    return overallRating;
  }
  
  /** Computes overallRating for a School that considers 
    * all factors, given input weights for the individual factors.<br>
    * Note that all weights have to be in the range of [1,5].
    * @param weightAcademics weight of academics
    * @param weightResearch weight of research
    * @param weightPubs weight of publications
    */
  public void setOverallRating (int weightAcademics, int weightResearch, int weightPubs) {
    // Ensure that the weights are between 1 and 5
    weightAcademics = (weightAcademics > 5)? 5 : weightAcademics; 
    weightAcademics = (weightAcademics < 1)? 1 : weightAcademics;
    weightResearch = (weightResearch > 5)? 5 : weightResearch; 
    weightResearch = (weightResearch < 1)? 1 : weightResearch;
    weightPubs = (weightPubs > 5)? 5 : weightPubs; 
    weightPubs = (weightPubs < 1)? 1 : weightPubs;
    
    overallRating = (weightAcademics * rateAcademics) +  
      (weightResearch * rateResearch) + (weightPubs * ratePubs);
  }
  
  
  /** Since the assignment wants a synonym for the OverallRating setter, we just call it
    * @param weightAcademics weight of academics
    * @param weightResearch weight of research
    * @param weightPubs weight of publications
    */
  public void computeRating (int weightAcademics, int weightResearch, int weightPubs) {
    setOverallRating (weightAcademics,  weightResearch,  weightPubs);
  }
  
  
  /**
   * Returns a formatted string of the instance values.
   * @return The information of the school
   */
  public String toString () {
    String S = "SCHOOL: " + name;
    S = S + "\t Academics: " + rateAcademics;
    S = S + "\t Research: " + rateResearch;
    S = S + "\t Publications: " + ratePubs;
    S = S + "\n Overall: " + overallRating;
    S = S + "\t Current rank: " + rankValue;
    S = S + "\n";
    return S;
  }
  
  /** Driver method to test this class
    */
  public static void main (String[] args) {
    int weightAcademics = 0;
    int weightResearch = 0;
    int weightPubs = 0;
    
    if (args.length != 3) 
    {
      //System.out.println("Please provide 3 weights [1..5] for Academics, Research and Publications\n");
      //System.exit(0);
      // Alternatively, we could have gotten some default values
      weightAcademics = 3;
      weightResearch = 4;
      weightPubs = 5;
      
    } else {
      weightAcademics = Integer.parseInt(args[0]);
      weightResearch = Integer.parseInt(args[1]);
      weightPubs = Integer.parseInt(args[2]);
    }
    
    School wellesley = new School("Wellesley", 15, 8, -5);
    
    wellesley.computeRating(weightAcademics, weightResearch, weightPubs);
    System.out.println(wellesley);
    
    wellesley.setName("LTC-Wellesley!");
    wellesley.setRateResearch(10);
    wellesley.setOverallRating(weightAcademics, weightResearch, weightPubs);
    wellesley.setRankValue(1);
    System.out.println(wellesley);
  }
  
}

