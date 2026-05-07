# LaundryPro

A comprehensive web-based laundry management system built with Spring Boot. LaundryPro enables customers to book laundry services, staff to manage jobs, and administrators to oversee all operations with features like order tracking, payments, reviews, and notifications.

## 🚀 Features

### Customer Features
- **User Registration & Login** - Secure authentication system
- **Job Applications** - Browse and apply for available laundry services
- **Order Tracking** - Real-time tracking of laundry orders
- **Payment Processing** - Integrated payment system with multiple payment options
- **Reviews & Ratings** - Leave feedback and rate completed services
- **Notifications** - Real-time updates on order status and special offers
- **Customer Dashboard** - Personalized dashboard to view orders and history

### Staff Features
- **Staff Dashboard** - Manage assigned jobs and workload
- **Job Management** - Accept, update, and complete jobs
- **Order Processing** - View and process customer orders
- **Performance Tracking** - Track completed jobs and ratings

### Admin Features
- **Admin Dashboard** - Comprehensive overview of all operations
- **Job Management** - Create, manage, and assign jobs to staff
- **Tax Settings** - Configure and manage tax rates
- **Staff Management** - Manage staff accounts and assignments
- **Report Generation** - Generate reports on orders, payments, and performance
- **Notifications Management** - Send notifications to customers
- **Analytics** - View key metrics and statistics

### Core Features
- **Notification System** - Real-time notifications for customers, staff, and admins
- **Tax Management** - Automatic tax calculation on orders
- **Report System** - Track issues and complaints from customers
- **Database Migrations** - Flyway-based database versioning

## 🛠️ Technology Stack

- **Backend Framework:** Spring Boot 3.5.6
- **Java Version:** Java 17
- **Database:** Microsoft SQL Server
- **ORM:** Spring Data JPA with Hibernate
- **Frontend:** HTML5, CSS3, JavaScript
- **Build Tool:** Maven 3.9+
- **Database Migration:** Flyway

## 📋 Prerequisites

Before running the application, ensure you have:
- **Java 17 or higher** installed
- **Maven 3.9+** installed
- **SQL Server** installed and running
- **SQL Server Management Studio (SSMS)** or similar tool for database setup (optional but recommended)
- **Git** for version control

## 🔧 Installation & Setup

### 1. Clone the Repository


### 2. Create the Database
Create a SQL Server database named `laundrypro_db`:

```sql
CREATE DATABASE laundrypro_db;
```

### 3. Configure Database Connection
Edit `src/main/resources/application.properties` and update the following:

```properties
# Database connection settings
spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=laundrypro_db;encrypt=true;trustServerCertificate=true
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
```

**Default Configuration (if using local SQL Server):**
- Server: localhost:1433
- Database: laundrypro_db
- Username: Admin
- Password: 1234

### 4. Build the Project
```bash
mvn clean package
```

Or for development with automatic restarts:
```bash
mvn spring-boot:run
```

## ▶️ Running the Application

### Option 1: Using Maven (Recommended for Development)
```bash
mvn spring-boot:run
```

### Option 2: Using JAR File (Production)
```bash
java -jar target/LaundryPro002-0.0.1-SNAPSHOT.jar
```

### Option 3: Using Maven Wrapper (Windows)
```bash
mvnw.cmd spring-boot:run
```

The application will start on `http://localhost:8080`

## 📱 Accessing the Application

### Web Interfaces

1. **Home Page:** `http://localhost:8080/`
2. **Login:** `http://localhost:8080/login`
3. **Register:** `http://localhost:8080/register`
4. **Customer Dashboard:** `http://localhost:8080/dashboard.html`
5. **Staff Dashboard:** `http://localhost:8080/staff-dashboard.html`
6. **Admin Dashboard:** `http://localhost:8080/admin-dashboard.html`
7. **Job Application:** `http://localhost:8080/Job_application.html`
8. **Order Tracking:** `http://localhost:8080/order-tracking.html`
9. **Payments:** `http://localhost:8080/Payment.html`
10. **Reviews:** `http://localhost:8080/Reviews.html`

## 🏗️ Project Structure

```
LaundryPro002/
├── src/
│   ├── main/
│   │   ├── java/com/laundrypro/
│   │   │   ├── controller/              # REST API controllers
│   │   │   │   ├── admin/               # Admin-specific controllers
│   │   │   │   ├── CustomerController.java
│   │   │   │   ├── StaffController.java
│   │   │   │   ├── LoginController.java
│   │   │   │   └── OrdersController.java
│   │   │   ├── service/                 # Business logic services
│   │   │   ├── model/                   # JPA entities
│   │   │   ├── repository/              # Data access layer
│   │   │   ├── DTO/                     # Data Transfer Objects
│   │   │   ├── config/                  # Configuration classes
│   │   │   ├── patterns/                # Design patterns
│   │   │   ├── jobs/                    # Job scheduling
│   │   │   ├── web/                     # Web utilities
│   │   │   └── LaundryPro002Application.java  # Entry point
│   │   └── resources/
│   │       ├── application.properties   # Application configuration
│   │       ├── static/                  # HTML, CSS, JS files
│   │       │   ├── css/                 # Stylesheets
│   │       │   ├── js/                  # JavaScript files
│   │       │   └── *.html               # HTML pages
│   │       └── db/migration/            # Flyway migrations
│   └── test/                            # Unit tests
├── target/                              # Compiled files (generated)
├── pom.xml                              # Maven configuration
└── README.md                            # This file
```

## 🗄️ Database Models

### Key Entities
- **Customer** - Customer user accounts
- **Staff** - Staff member accounts
- **Orders** - Laundry orders placed by customers
- **Payment** - Payment transactions
- **Review** - Customer reviews and ratings
- **Report** - Issue reports from customers
- **Notification** - System notifications
- **TaxSettings** - Tax configuration

## 🔌 API Endpoints

### Authentication
- `POST /login` - User login
- `POST /register` - User registration

### Customers
- `GET /customer/*` - Customer-related endpoints
- `POST /customer/orders` - Place new order

### Staff
- `GET /staff/*` - Staff-related endpoints
- `GET /staff/orders` - View assigned orders

### Orders
- `GET /orders` - Get all orders
- `GET /orders/{id}` - Get order details
- `POST /orders` - Create order
- `PUT /orders/{id}` - Update order
- `DELETE /orders/{id}` - Cancel order

### Payments
- `POST /payments` - Process payment
- `GET /payments/{id}` - Get payment details

### Notifications
- `GET /notifications` - Get user notifications
- `POST /notifications/send` - Send notification

### Admin
- `GET /admin/*` - Admin-specific endpoints
- `POST /admin/staff` - Create staff account
- `PUT /admin/taxsettings` - Update tax settings

## 🚨 Troubleshooting

### Database Connection Issues
1. Verify SQL Server is running
2. Check connection string in `application.properties`
3. Ensure database credentials are correct
4. Test connection using SSMS

### Port Already in Use
Default port is 8080. To change it, add to `application.properties`:
```properties
server.port=8081
```

### Maven Build Issues
```bash
# Clear Maven cache
mvn clean

# Rebuild
mvn clean package
```

### Application Won't Start
1. Check application logs for error messages
2. Verify Java version: `java -version` (should be 17+)
3. Ensure all dependencies are downloaded: `mvn dependency:resolve`

## 📊 Logging

Logs are displayed in the console. To enable file logging, add to `application.properties`:
```properties
logging.file.name=logs/laundrypro.log
logging.level.com.laundrypro=DEBUG
```

## 📝 Database Migrations

The application uses Flyway for database migrations. Migration scripts are located in:
```
src/main/resources/db/migration/
```

Existing migrations:
- `V1__init.sql` - Initial schema
- `V2__extend_review_table.sql` - Review table updates
- `V3__add_report_columns.sql` - Report columns
- `V4__add_notifications_table.sql` - Notifications
- `V5__add_default_staff_account.sql` - Default staff
- `V6__add_customer_id_to_notifications.sql` - Customer notifications
- `V7__add_tax_settings.sql` - Tax settings

## 🔒 Security Considerations

- Credentials in `application.properties` should be moved to environment variables for production
- Use HTTPS in production deployment
- Implement proper authentication and authorization mechanisms
- Sanitize user inputs to prevent SQL injection

## 📄 Default Accounts

After running migrations, the following default accounts may be available:
- **Admin Account** - Check migrations for default credentials
- Create additional staff accounts through the admin panel

## 🚀 Deployment

### Building for Production
```bash
mvn clean package -DskipTests
```

### Running JAR
```bash
java -jar target/LaundryPro002-0.0.1-SNAPSHOT.jar --server.port=80
```

## 📄 License

This project is licensed under the terms specified in the LICENSE file.
