># Model Package details:

We have following models:
1. [User](#user)
2. [Product](#product)
3. [Bid](#bid)
4. [Role](#role)
5. [ConfirmationToken](#confirmationtoken)

For this model we have used builder pattern and implemented some spring security concept.

For the builder, we have to make controller where it will be redirected where it will be saved and can be display later.

For Prototype pattern, we created PostPrototype with annotation @scope("prototype"). 
This will load the prototype for post and when there is any modification it won't load the whole list of posts again just the one that is modified.

# Models and their Responsibilities
## User
- Used to store user information.

## Product
- Used to store product information.

## Bid
- Used to store bid information.

## Role
- Used to store user roles.
- Types of roles
    1. ROLE_ADMIN
    2. ROLE_USER

## ConfirmationToken
- Used to store confirmation token once user clicks register with valid email.
- One to One relationship with the User.
