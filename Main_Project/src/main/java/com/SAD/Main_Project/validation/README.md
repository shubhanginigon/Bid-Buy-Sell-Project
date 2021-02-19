># User Validator (mail id)
While we have implemented @NotBlank in the User.java, sometimes we want more customized validations and this can be done by implementing Validator.

# Note:

1. "duplicate.user.email"
2. “size.user.username”
3. "size.user.password"
4. "diff.user.passwordConfirm"

- These specify the message identifier which will be tied to a file specifying the error messages in "_messages.properties_" via configuration.
