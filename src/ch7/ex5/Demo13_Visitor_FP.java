package ch7.ex5;

public class Demo13_Visitor_FP {

	public static void main(String[] args) {
		ISceneElement1 scene = new Scene1("Primary Scene");
		
		ISceneElementVisitor1 printVisitor = 
				visitor -> System.out.println("Printing " + visitor.getName());
		ISceneElementVisitor1 refreshVisitor = 
				visitor -> System.out.println("Refreshing " + visitor.getName());
		
		// visitor1
        scene.accept(printVisitor);
        // visitor2
        scene.accept(refreshVisitor);
        // visitor3
        scene.accept(v -> System.out.println("Another visitor operation on " + v.getName()));
	}
}

@FunctionalInterface
interface ISceneElement1 {
	public String getName();
	public default void accept(ISceneElementVisitor1 visitor) {
		visitor.visit(this);
	};
}

@FunctionalInterface
interface PlantElement1 extends ISceneElement1 {}

@FunctionalInterface
interface BuildingElement1 extends ISceneElement1 {}

@FunctionalInterface
interface ISceneElementVisitor1 {
	public void visit(ISceneElement1 element);
}

class Scene1 implements ISceneElement1 {
	
	ISceneElement1[] elements;
	private String name;
	
	public Scene1(String name) {
		this.name = name;
		BuildingElement1 building = () -> "Tool Shed";
		PlantElement1 plant = () -> "Oak Tree";
		this.elements = new ISceneElement1[]{
			building,
			() -> "Brick House",
			plant,
			() -> "Lawn"
		};
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void accept(ISceneElementVisitor1 visitor) {
		for (ISceneElement1 element : elements) {
			element.accept(visitor);
		}
		visitor.visit(this);
	}
}
