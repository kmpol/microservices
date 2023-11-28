package pl.karol.customer.request;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email
) {
}
