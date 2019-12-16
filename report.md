# LSD Exam Report
## Backend team
Hazem Saeid - cph-hs151

Tjalfe Møller - cph-tm166

David Carl - cph-dc62

---
## 1. Requirements, architecture, design and process
We want to start out with the technical part of our project. 

### 1.1. System requirements
As a user you should be able to go in and search for a trip by airplane. Their search had to fulfill some of our requirements which were, give us a outbound date, outbound airport as a constant requirement and inbound date and inbound airport if the customer decided to take a round trip. 

Another requirement on our system is that the user that books the flights are not the customers themself, its travel
agencies. So there had to be a login system where the travel agent should identify themself with a username, password and agency number.

### 1.2. Development process
In our development process we used several tools while developing our system.
The tools we used are the following, a VCS tool for better collaboration between each other, a issue tracker / kanban board, several CI tool, a communication tool.

For our VCS tool we used github since its based on git, and we all had a good knowledge about how to use git and github. This made it a fairly painless setup process for us to setup and use togheter.

As our issue tracker / kanban board we used [zenhub](https://www.zenhub.com/), which is based on github issues. One of the features that hooked us on this issue tracker compared to so many other trackers was the possibility to access it straight on the github website by adding their extension to your browser. This made it easy for us to alway access our issue tracker / kanban board.

As one of our 2 CI (Continous Integration) tool we used [CircleCi](https://circleci.com/). We have it configured to run all test once we commit to the branch we work on, and run test once we make a pull request. This way we know if the code works (depends on developers making the necessary tests) before we decide to rebase our code base unto our master branch. As for our second CI tool we decided to use [Docker hub](https://hub.docker.com/) for automaticly building our Docker image we would then use for deployment. We decided to use docker to simplify our deployment process and safety for our runtime, more on this later.

As our communication tool we decided to use Discord, this decision was based on it both having a feature rich text chat, voice chat, and the possibility to screenshare also if we had to help each other. As for the text chat it had the possibilities to upload images direcly and had markdown support to make it easier to share code snippets and more.

So how the workflow then went using our tools would be the following. I go to see what current issues we have avaible in our kanban board (Zenhub), I then assign myself to let others know that I am working on this issue. Then when I am done with this task I push the branch up to our VSC tool and make a merge request. A independent third party of the group will look through the pull request and either accept or deny it depending on CircleCI result and the code quality. If its being accepted we perform a rebase into the master branch and Docker Hub would automaticly perform a build of the newest master branch. If we want to make a semver release on Docker Hub we should do a Github Release with the version number, Docker Hub will then build the image with that tag.

<In this part you should show off by telling us all you know about software
development processes and describe which concepts you used to structure your
development./>

### 1.3. Software architecture

<In this section you illustrate and describe the architecture of your Hackernews clone. That is, you describe how your system is structured and how the different parts interact and communicate with each other./>

### 1.4. Software design

One of the big concerns we had was that we were supposed to make contact between our frontend and our backend through something else than REST Endpoints since that was what we were used to do. Suddendly we were given a framework called Bean which we needed to implement for communication between frontend and backend.
We understood what was smart about it, since we could (did) make a contract we had to follow, so it was really hard for us to screw up the communication link, and if we both did it correctly it wouldnt take more than 5 min to implement the real backend from some mock state. However after a couple of long days of debugging we managed to get it up and running correctly, this was both from problem of our selection of application server and configuration in our code. We started out with using Tomcat in our Docker images and this was fault number 1, since Tomcat didnt support Bean. After reading up on it we figured out we needed to use Wildfly, however this didnt work out of the box either, we had to change some settings for it to work.

<Here you should sketch your thoughts on the software design *before* you
started implementing the system. This includes describing the technical
concerns you had about the system before you started development, together
with all the technical components you came up with to fix these concerns and
meet the requirements./>

### 1.5. Software implementation
<This section should describe your actual implementation. Mainly how well you
followed the requirements, process and software design you began with.
If your system changed during this phase you should summarise the unexpected
events/problems and explain how you solved them./>

## 2. Maintenance and SLA status

For checking our uptime of our application we have setup Grafana to run on the server monitoring the following things, Server performance, Docker containers.

Monitoring our Docker Containers enables us to be able to monitor how much storage, RAM, CPU and network trafic they use. We are also able to see when the containers are running and when they are not. This gives us the ability to monitor their uptime and downtime. Ideally we would also implement other ways to do this, one way is setup [uptimerobot](https://uptimerobot.com/), its a service that pings your service with a 5-min interval and send you a email if it no longers recieve a response from the service that it pings. It is already implemented on some tother services on the server, so it have a half cover since if the server dies completly we will also be alerted of this. However we will not be alerted if just the backend or frontend application crash.

As for maintenance it would be ideal for us to run this in a kubernetes setup or Docker swarm so we could make a rolling release and this way not affect people updating our service. Even though its something we have not implemented, we still want to write about how it could be done as if we used Docker swarm, and what it would mean for our end users. 
When we decide to release a new version we would perform a rolling release on our swarm, we simply replace the image on a node one after one, to make sure this process goes a smoothly as possible it WILL only release on 1 image at a time, per default settings. If one of our nodes fail to update to our new version, the rolling release will pull the handbrake and stop the release by itself. This ensures you have a chance to see what went wrong in the deployment and make sure you still have a service that works once you went on a total rollout. 

If we choose to run this in a kubernetes Cluster instead of a Docker swarm we will have even more [update strategies](https://blog.container-solutions.com/kubernetes-deployment-strategies) than just a rolling release. This gives us even more control over how we want to perform our update, for some features it could be interresting to test them out first, this is where we would deploy a a/b testing strategy.

<This section describes the process of maintaining the software over time,
starting from the hand-over to the shutting down of your system. The section
should be written from the viewpoint of the operator, *not* the developers./>

### 2.1. Hand-over
<In this part, you should describe the hand-over of the system you were
operating. Specifically you should comment on the quality of the documentation you received and whether you felt well equipped to maintaining the system./>

### 2.2. Service-level agreement
<Here you should include the service level agreement you entered together with
the group you were operating, including the metric itself and the threshold
you agreed upon for that metric. If you had any disagreements about the SLA
you should describe them and explain how you found an agreement./>

### 2.3. Maintenance and reliability
<Kan man komme ind på hvordan vi kørte docker med restart always unless stopped/>

<This part should contain a description on how you experienced the actual
operation. Explain how you actually monitored the system to ensure that the SLA
was upheld, and describe any incidents you experienced that broke (or could
potentially break) the SLA. Remember to include documentation for each
incident! Finally you should conclude how well the developers responded to your
issues and conclude on how reliable the system was overall./>

## 3. Discussion

## 3.1. Technical discussion
<This part summarises both the first and second part of the report by giving
an overview of the good and bad parts of the whole semester project. Be
critical and honest./>

## 3.2. Group work reflection & Lessons learned
<Give a short reflection on what were the three most important things you learned during the project. The lessons learned are with regards to both, what worked well and what worked not well. These reflections can cover anything from the sections above. That is, development process, architectural and design decisions, implementation, maintenance, etc. If you chose to use roles (project manager, architect, devops etc.) you should use those to reflect on whether they improved the process or not./>

<Additionally, focus on both, your work as developers as well as operators./>