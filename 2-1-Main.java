class Man extends BasePerson implements Person {
	private final String name;
	private final String description;
	protected Integer count;
	
	Man(final String name, final String description){
		this.name = name;
		this.description = description;
		this.count = 0;
	}
	
	protected void move() {
		System.out.print("I'm moving...\n");
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public int changeSomething() {
		this.count = this.count - 1;
		return this.count;
	}
}


class SuperMan extends Man {
	SuperMan(){
		this("superMan", "I can fly.");
	}
	
	SuperMan(final String name, final String description) {
		super(name, description);
	}
	
	@Override
	protected void move() {
		System.out.print("I am flying...\n");
	}
	
	void fly() {
		System.out.print("Fly! SuperMan!\n");
	}

	@Override
	public int changeSomething() {
		this.count = this.count+1;
		return this.count;
	}
}
