package MVC;


// This is the model
public class AstroCards {
	private String ability;
	private String name;
	private String duration = "30 seconds";
	
	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getAbility() {
		return ability;
	}

	public void setAbility(String ability) {
		this.ability = ability;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}