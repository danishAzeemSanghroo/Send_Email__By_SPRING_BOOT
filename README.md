# Send_Email__By_SPRING_BOOT


# Email Service API

This project provides a simple REST API to send emails using Spring Boot and JavaMail.

## Features

- Send emails by providing subject, message, and recipient.
- Utilizes Gmail SMTP server for sending emails.
- Cross-origin support for API requests.

## Prerequisites

- Java 11 or higher
- Maven
- Gmail account for sending emails

## Getting Started

### Clone the repository

```bash
git clone https://github.com/yourusername/email-service-api.git
cd email-service-api
```

### Configure Email Credentials

Replace `yourEmail` and `yourEmailPassword` in `EmailService.java` with your Gmail credentials:

```java
return new PasswordAuthentication("yourEmail","yourEmailPassword");
```

### Build and Run the Application

```bash
mvn clean install
mvn spring-boot:run
```

### API Endpoints

#### Send Email

- **URL:** `/email/send`
- **Method:** `POST`
- **Request Body:**
    ```json
    {
        "subject": "Your email subject",
        "message": "Your email message",
        "to": "recipient@example.com"
    }
    ```
- **Response:**
    - `200 OK` - Email sent successfully
    - `500 Internal Server Error` - Failed to send email

### Example cURL Command

```bash
curl -X POST http://localhost:8080/email/send \
     -H "Content-Type: application/json" \
     -d '{
           "subject": "Test Subject",
           "message": "This is a test email.",
           "to": "recipient@example.com"
         }'
```

## Project Structure

- `EmailController.java`: Handles HTTP POST requests to send emails.
- `EmailService.java`: Contains the logic to send emails using JavaMail.

