># Model Package details:

We have create four model as follows:
1. User
2. Product
3. Bid
4. Role

For this model we have used builder pattern and implemented some spring security concept.

For the builder, we have to make controller where it will be redirected where it will be saved and can be display later.

For Prototype pattern, we created PostPrototype with annotation @scope("prototype"). This will load the prototype for post and when there is any modification it won't load the whole list of posts again just the one that is modified.