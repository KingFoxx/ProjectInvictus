# Invictus - Crypto Storage 

Devid Bakin
Test Coverage: 99.3% 

Jira Board Link - [**Jira**](https://northerncreator.atlassian.net/jira/software/projects/PROJ/boards/5/backlog)
Presentation Link - [**Presentation**](https://docs.google.com/presentation/d/1szYZ3tBoF6AyKC1DSDdck1hv2dDdRL2C-mCgFithYuA/edit#slide=id.g11b3ef340bb_0_67)

## Introduction:

For this project it was given an MVP to generate a hobby project with the CRUD application which was studied during the training. During the project the following practices were used:
* Project Management - Jira was used to make a todo list for the project
* Database - MySQL was used to have a relational database 
* Java SE & Spring Boot - Application backend completed through Spring Boot following OOP
* HTML, CSS, JS - Fronted completed with integrated API for fully functioning website
* Testing - Testing of backend using integrated test suite

### Planning
Jira allowed to track the progress of the project through the use of user stories and tasks that you can see down below. These were then thrown into a sprint and followed and checked off as the days went by. Stories were organized into Epics and were blocked by tasts to ensure they were done correctly.

Throughout the project build I completed various sprints, grouping the issues from epics to complete different sections.

Once I had decided on my user stories I started to think about the design for the website. Using Invision Freehand I created a wireframe and stuck to this throughout my front-end creation.

___

![img](https://i.imgur.com/XNtg2BR.png)
<p align = "center">Jira</p> 

___

![img](https://i.imgur.com/dRiFq0r.png)
<p align = "center">Jira 2</p> 

___

![img](https://i.imgur.com/ESkzRth.png)
<p align = "center">Invision</p> 

___


### Databases

MySQL was used to store the data that is provided by the user. Columns for Name, Abbreviation, CryptoCost and Actual cost of coins were used. These inputs were tested during the inital phase via postman.

![img](https://i.imgur.com/yW3b0C4.png)
<p align = "center">MYSQL</p>

___


### Backend + Testing

Back End of the application was made in Eclipse using Spring boot and tests were created once the functionalities were done. Here is an example of a functionality test.

```
	@Test
	void getAllTest() throws Exception {
		RequestBuilder req = get("/getAll");

		List<Crypto> testCrypto = List.of(new Crypto(1, "BitCoin", "BTC", 3.1, 15000.34),
				new Crypto(2, "Etherium", "ETH", 5.3, 20000.56), new Crypto(3, "LiteCoin", "LTC", 300.0, 1500.56));
		String json = this.mapper.writeValueAsString(testCrypto);

		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(json);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
```
___

### Frontend

The front-end is built from HTML, CSS and JavaScript. I used the Bootstrap framework for various components. This helped me make the website more professional using forms.

The HTML and CSS are used to create the look of the website, I used CSS to animate the initial button on the Home page as was planned with Invision. All the background is animated in professional "nebula" colours to make it a cleaner, professional and futuristic look.

![img](https://i.imgur.com/OPKVeoI.png)
<p align = "center">Home Page</p>

___

![img](https://i.imgur.com/2uX6SrN.png)
<p align = "center">WelcomePage</p>

___

___


#### Prerequisites

To run the application the following is required:

1. [**Git**](https://gitforwindows.org/)
2. [**Jira**](https://www.atlassian.com/software/jira)
3. [**GitHub**](https://github.com/)
4. [**MySQL**](https://dev.mysql.com/downloads/windows/installer/8.0.html)
5. [**Java**](https://www.oracle.com/java/technologies/downloads/#java17)
6. [**Springboot**](https://spring.io/projects/spring-boot)
7. [**VS Code**](https://code.visualstudio.com/)



### Built With

* Git
* MySQL
* Java
* SpringBoot
* HTML
* CSS
* JS
* MockMVC
* Invision

___

### Authors

* Devid Bakin - Project Completed 

___


