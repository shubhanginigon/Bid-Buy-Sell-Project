># Bid-Buy-Sell-Project
## Software Architecture Design Project 2021

#### _**Team Member:**_
1. Shubhangini Gontia (Leader)
2. Suyogya Ratna Tamrakar
3. Younten Tshering

#### _**Project Topic:**_
>_“E-commerce website to sell second hand product; Bidding system for AIT.”_

It's idea is like any e-commerce platform in which buying and selling of goods are done. But the core addition will be the system of bidding before buying anything.The products added will be subjected to certain time frame where users most probably buyers will be allowed to bid on their products and are able to buy the product once the bid time closes or when there are no other bidders. 
In case of AIT, this platform can be used to sell the used items. More than one person could be interested in the same product, but with this system, there will be a sense of competition as one person bids over another user’s bid at the same time and the product value will also increase.

#### _**Context Diagram**_
![alt](img/context_diagram.png)

#### _**Architecture:**_
 - Model-View Controller (MVC)
 - Client-server

#### _**Detail Quality attribute analysis:**_

| Quality attributes | Priority Rating (L, M, H) | Priority Justification |
| :----| :--: |  :----|
| Performance | H | The output is to show who won and is bidding for the product in this system and we need to focus on concurrency and response time.<br/> This system should be available most of the time and it consists of transactions of lots of users concurrently.<br/> - The application should respond to a user within 2 seconds. <br/> - The application should be able to handle 5 transactions per second in the peak load time. <br/> - The application will be available with the uptime of 95% between 6.00 am to 12.00 am.|
| Security | M | Since the site is buying and selling product, the payment or transactions with payment gateways might be incorporated so storing all the credit card information of the users, hence requiring high level of security mechanisms.<br/> - The system should be able to restore backward data of 24 hours (maximum 1 month) within 2 hours as a recovery function. <br/> - All the transaction data between client and server must be encrypted.|
| Usability | M | System should be easy to modify since data will not remain the same all the time and input sources may change with newer buyers and sellers. For users with different privileges/roles, the system should modify and make changes accordingly.<br/> - The web app must support devices running on iOS versions 10.0 or later. <br/> - The web app must support devices running on android versions 7.0 or later. <br/> - The web app should be easy to operate  by users with a certain navigation menu or option. No need for a user manual.|
| Interoperability | L | For the website we just import and integrate various information with pictures into the system from the seller. |
| Scalability | L | With data, the storage size will increase but can manage before time. This app can be made vertically scalable when there is lack of memory storage. |

#### _**Before Quality attribute analysis:**_
![alt](img/quality_attributes.png)


#### _**Responsibility of team member and modules**_
As of now, we have identified the major Task or modules as follows:
1. **User modules**
Post information and update the details.

2.  **DB modules**
Bid the price of product and view the increasing price in the event time.

3. **Admin modules**
Security of the bidding system and keeping track of the seller and buyer with profit.

>Team member will be splitting the modules as per the architectural patterns implementation and since all the members are in campus, we are planning to work together.

#### _**Meeting schedule**_
* Every Wednesday – 8:00 PM to 10:30 PM  
  - Progress and issues meeting
* Every Sunday – 6:00 PM to 10:30 PM  
  - Pair programming
