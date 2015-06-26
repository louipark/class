//UIUC CS125 FALL 2012 MP. File: Person.java, CS125 Project: Challenge6-RecursionSee, Version: 2012-11-03T10:40:42-0500.574579000
/**
 * @author lzhou8
 *
 */
public class Person
{
private final String name;
private final int age;
private final char gender;
private final Person child1; //left child
private final Person child2; //right child

public Person(String name, int age, char gender, Person c1, Person c2)
{
    this.name=name;
    this.age=age;
    this.gender=gender;
    this.child1 = c1;
    this.child2 = c2;
}

public String toString()
{
    return name+"*"+age+"*"+gender;
}

public String getName() 
{
	return name;
}

public int getAge() 
{
	return age;
}

public char getGender() 
{
	return gender;
}

public boolean equals(Person p)
{
	return (this.name.equals(p.name)) &&
			(this.age==p.age) &&
			(this.gender==p.gender);
}


public void print() 
{
   System.out.println(this);
   if(child1 != null)
       child1.print();
   if(child2 != null)
       child2.print();
}

public int count() // total person count including this object
{
	int count=1;
    if (child1!=null)count+=child1.count();
	if (child2!=null)count+=child2.count();
	return count;
}

public int countGrandChildren() // but not greatGrandChildren
{        int count = 0;
   if(child1 != null){
       if(child1.child1 != null) count++;
       
       if(child1.child2 != null) count++;
}
  if(child2 != null){
    if(child2.child1 != null) count++;
    
    if(child2.child2 != null) count++;
}
return count;

	//throw new IllegalArgumentException("Not Yet Implemented");
}



public int countMaxGenerations()
{
	int sum1 =1;
	int sum2=1;
	if (child1!=null)sum1=child1.countMaxGenerations();
	else sum1=0;
	if (child2!=null)sum2=child2.countMaxGenerations();
	else sum2=0;
    
	if(sum2>sum1)
        return sum2+1;
    else
        return sum1+1;

	//throw new IllegalArgumentException("Not Yet Implemented");   
}

public int countGender(char gen)
{
	int sum =0;
	if (this.gender==gen)sum++;
	if (child1!=null)sum+=child1.countGender(gen);
	if (child2!=null)sum+=child2.countGender(gen);
	return sum;
}


public Person search(String name, int maxGeneration)
{
    Person a,b;
    if(this.name.equals(name)) return this;
    else if(this.child1 == null && this.child2 == null)return null;
    else if(maxGeneration == 0) return null;
    
    if(this.child1 != null) a = this.child1.search(name, maxGeneration-1);
    else a = null;
    
    if(this.child2 != null) b = this.child2.search(name, maxGeneration-1);
    else b = null;
    
    if(a != null)return a;
    else if(b != null) return b;
    else return null;
    
	//YOUR CODE HERE
	//throw new IllegalArgumentException("Not Yet Implemented");
}

} // end of class
