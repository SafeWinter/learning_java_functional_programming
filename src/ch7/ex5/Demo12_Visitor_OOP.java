package ch7.ex5;

public class Demo12_Visitor_OOP {

	public static void main(String[] args) {
		ISceneElement scene = new Scene("Primary Scene");
        scene.accept(new SceneElementPrintVisitor());
        scene.accept(new SceneElementRefreshVisitor());
	}
}

interface ISceneElement {
	public String getName();
	void accept(ISceneElementVisitor visitor);
}

interface ISceneElementVisitor {
	public void visit(ISceneElement element);
}

class SceneElementPrintVisitor implements ISceneElementVisitor {
	@Override
	public void visit(ISceneElement element) {
		System.out.println("Printing " + element.getName());
	}
}

class SceneElementRefreshVisitor implements ISceneElementVisitor {
	@Override
	public void visit(ISceneElement element) {
		System.out.println("Refreshing " + element.getName());
	}
}

class BuildingElement implements ISceneElement {
	private String name;
	
	public BuildingElement(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void accept(ISceneElementVisitor visitor) {
		visitor.visit(this);
	}
}

class PlantElement implements ISceneElement {
	private String name;
	
	public PlantElement(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void accept(ISceneElementVisitor visitor) {
		visitor.visit(this);
	}
}

class Scene implements ISceneElement {
	
	ISceneElement[] elements;
	private String name;
	
	public Scene(String name) {
		this.name = name;
		this.elements = new ISceneElement[]{
			new BuildingElement("Tool Shed"),
			new BuildingElement("Brick House"),
			new PlantElement("Oak Tree"),
			new PlantElement("Lawn")
		};
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void accept(ISceneElementVisitor visitor) {
		for (ISceneElement element : elements) {
			element.accept(visitor);
		}
		visitor.visit(this);
	}
	
}