import java.io.*;

public class Match implements Serializable{
	private Seeker seeker;
	private Listing listing;
	
	public Match(Seeker seeker, Listing listing){
		this.seeker		= seeker;
		this.listing	= listing;
	}

	public Seeker getSeeker() {
		return seeker;
	}

	public void setSeeker(Seeker seeker) {
		this.seeker = seeker;
	}

	public Listing getListing() {
		return listing;
	}

	public void setListing(Listing listing) {
		this.listing = listing;
	}
	
	
}
