># _This is considered the second phase of our software development for the SAD project._


## Deliverables:

> Following files are uploaded in this directory.

1. **Detailed - Refined design documents**

- detailing important diagrams of our architecture, including use-case diagrams, class-diagrams, sequence diagrams.

2. **A scientific report in two-column format** 

- containing INTRODUCTION , RELATED WORK, METHODOLOGY (DESIGN)

>## Sequence Diagram for UseCase: “Bid on product”
>`Architectural challenges of our system was handling multiple concurrent transactions and updating the product price in real time for ongoing bidding processes.`

There will be many users active on the system and they will be able to bid on the products. But multiple users may place bids on the same product at the same time.
If the product is being bided by someone, there will be multiple users who will be on the same page waiting or trying to bid. If one bid is updated, other users must instantly see the updated bid amounts on their systems. This must be nearly real-time.


![alt](/Architectural%20Design%20Documents%20(After%20Mid%20Term)/BBS%20Sequence%20Diagram%20V2.png)

Above sequence diagram is for the use case 'Bid on product'. Here we have shown two actors as client 1 and client 2 and bidController, server, bidRepo and bid(Entity) as the object for the sequence diagram. As shown in the sequence, when client 1 and client 2 both request to update the bid amount simultaneously the timestamp taken here will be till nanosecond to diminesh the possibility of clicking the bid at the same time. Once, the request is send to the server, it will use locking to lock object and further proceed to updatet he bid entity. When the request from the second actor client 2 is sent to the server, say after 1 nanosecond, it will create another thread for the request and try to request the lock object, but since the thread 1 is already using it thread 2 will be sent to wait state until the lock is released by thread 1. After that, thread 2 will proceed to update the bid, and bid will be updated if the value is more than the latest bid amount. 

>## Architectural Design

![alt](/Architectural%20Design%20Documents%20(After%20Mid%20Term)/Architectural%20Design.png)

>#### _**Work Break Down**_
Progression table:

| Activities 	 | Remarks  |
| :----| :--: |
| 1.	Planning|   |
| 1.1. Project topic, problem statement and System scope | Done |
| 1.2. Assignment of members, their roles and scheduling | Done |
| 1.3. Setting up project git repo | Done |
| 1.4. Quality attribute analysis | Done |
| 1.5.	Background study on architecture and design patterns | Done |
| 2.	Project requirements |  |
| 2.1.	 Determining and analysis of system requirements| Done| 
| 2.2.	 Initial UI Mockups design  | Done |
| 2.3.	 Preliminary Use case diagram and sequence diagram| Done |
| 2.4.	 One series of mockups for one use case.  | Done|
| 2.5.	 Risk and mitigation plan | Done |
| 2.6.	 Software requirements document.	 | Done |
| 3.	Architectural Design |  |
| 3.1.	 Design analysis | Done |
| 3.2.	 Final Use-case diagrams, class-diagrams, sequence diagrams, deployment diagrams	 | Done |
| 3.3.	 Literature review (RELATED WORK)	 | Done |
| 3.4.	 Draft Scientific report	| Done |
| 4.	Implementation 	 |  |
| 4.1.	 Code design patterns |  Done |
| 4.2.	 Home page, login form, registration form | Done |
| 4.3.	 Email functionality with authentication and authorization| Done |
| 4.4.	 Product model 	 | Done |
| 4.5.	 Bidding model| Done |
| 5.	Testing 	 |  |
| 5.1.	 Unit testing 	 | progress |
| 5.2.	 Integration testing 	 | progress |
| 5.3.	 Performance testing	 | progress |
| 5.4.	 Stress testing 	 | progress |
| 5.5.	 Acceptance testing	 | progress |
| 5.6.	 Testing Documentation	 | progress |
| 5.7.	 Update Scientific report	 | progress |
| 6.	Documentation 	 | progress |
| 6.1.	 Presentation slide	  |  |
| 6.2.	 Final Scientific report	 | progress |
| 6.3.	 All updated Requirement, Design, Testing documents	 | progress |

#### _`**Project logo design to go green without throwing second hand product**`_
![alt](logo.png)

