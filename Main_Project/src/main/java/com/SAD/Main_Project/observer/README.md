># Observer Pattern

Observer pattern define one to many dependency between objects, when one object changes state, all its dependents are notified and updated accordingly. 

We are using observer for the user who subscribe to the post to follow the post on the home page. Users can follow the post to know when is the bidding is going to start, the current bidding amount and when the bid gets completed, notify the winner. 

**For that we created the interface PostObserver with following methods:
1. subscribeUser(Observer observe)
2. unsubscriberUser(Observer observe)
3. notifyObserver()
4. getUpdate(Observer observe)

**Interface Observer with methods 
1. updateObserver()
2. setProduct(PostObserver post)

**Class PostObservers to implement PostObserver

