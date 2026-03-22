# Cinema Ticket Booking System

A Java Swing desktop application for managing cinema ticket bookings. Built with Apache NetBeans IDE 28 using the Ant build system.

---

## Table of Contents

1. [Overview](#overview)
2. [Project Structure](#project-structure)
3. [How to Run](#how-to-run)
4. [User Roles](#user-roles)
5. [Features by Role](#features-by-role)
6. [OOP Concepts Used](#oop-concepts-used)
7. [Data Storage](#data-storage)
8. [Default Accounts](#default-accounts)
9. [Package Summary](#package-summary)

---

## Overview

The Cinema Ticket Booking System supports three types of users — Cinema Manager, Ticketing Clerk, and Customer. Each user logs in and is directed to their own dashboard. All data is stored in plain text files (no database required).

---

## Project Structure

```
CinemaBookingApp/
├── src/
│   ├── main/
│   │   └── Main.java                  -- Entry point
│   ├── main_running/                  -- Data model classes
│   │   ├── User.java                  -- Abstract base class
│   │   ├── Manager.java
│   │   ├── TicketingClerk.java
│   │   ├── Customer.java
│   │   ├── Movie.java
│   │   ├── Showtime.java
│   │   ├── Seat.java
│   │   ├── Booking.java
│   │   ├── Payment.java
│   │   ├── Displayable.java           -- Interface
│   │   └── Saveable.java              -- Interface
│   ├── main_logics/                   -- Service/logic classes
│   │   ├── FileHandler.java
│   │   ├── AuthService.java
│   │   ├── MovieService.java
│   │   ├── ShowtimeService.java
│   │   ├── BookingService.java
│   │   └── PaymentService.java
│   ├── ui/                            -- Login and registration screens
│   │   ├── LoginFrame.java/.form
│   │   ├── RegisterFrame.java/.form
│   │   ├── SeatSelectionPanel.java
│   │   ├── ReceiptDialog.java
│   │   ├── manager/                   -- Manager UI screens
│   │   │   ├── ManagerDashboard.java/.form
│   │   │   ├── ManageMoviesPanel.java/.form
│   │   │   ├── ManageShowtimesPanel.java/.form
│   │   │   ├── ManagePricingPanel.java/.form
│   │   │   └── ReportsPanel.java/.form
│   │   ├── customer/                  -- Customer UI screens
│   │   │   ├── CustomerDashboard.java/.form
│   │   │   ├── CustomerMoviesPanel.java/.form
│   │   │   ├── CustomerBookingsPanel.java/.form
│   │   │   ├── CustomerProfilePanel.java/.form
│   │   │   └── BookingPanel.java/.form
│   │   └── clerk/                     -- Clerk UI screens
│   │       ├── ClerkDashboard.java/.form
│   │       ├── ClerkBookingPanel.java/.form
│   │       ├── ClerkManageBookingsPanel.java/.form
│   │       └── ClerkScreeningsPanel.java/.form
│   └── data/                          -- Text file database
│       ├── users.txt
│       ├── movies.txt
│       ├── showtimes.txt
│       ├── seats.txt
│       ├── bookings.txt
│       ├── payments.txt
│       └── discounts.txt
├── build.xml                          -- Ant build file
└── nbproject/                         -- NetBeans project config
```

---

## How to Run

### Using Apache NetBeans IDE 28

1. Open NetBeans IDE.
2. Go to **File → Open Project** and select the `CinemaBookingApp` folder.
3. Click the **Run Project** button (green play button) or press `F6`.

### Using the Command Line

```bash
# Compile
javac -d build/classes -sourcepath src src/main/Main.java

# Run
java -cp build/classes main.Main
```

---

## User Roles

| Role | Default Username | Default Password |
|------|-----------------|-----------------|
| Cinema Manager | `admin` | `admin123` |
| Ticketing Clerk | `clerk1` | `clerk123` |
| Customer | (register first) | (set on register) |

Customers must register a new account from the login screen before logging in.

---

## Features by Role

### Cinema Manager
- **Manage Movies** — Add, update, and soft-delete movies (deactivated movies are hidden from customers but not erased).
- **Manage Showtimes** — Schedule showtimes for movies, set hall number, date, time, and base price. Seats are automatically generated when a showtime is created.
- **Manage Pricing** — Set discount percentages for Senior, Student, and Child customers.
- **Reports** — View a full list of all bookings with movie names, total revenue, and booking status summaries.

### Ticketing Clerk
- **Book Tickets** — Book tickets on behalf of walk-in customers. Select a movie, showtime, and seats from the interactive seat grid.
- **Manage Bookings** — View and cancel existing bookings.
- **View Screenings** — Browse all active showtimes and their seat availability.

### Customer
- **Browse Movies** — View all currently active movies with details.
- **Book Tickets** — Select a movie, choose a showtime, pick seats, apply a discount, and pay. A receipt is shown after successful booking.
- **My Bookings** — View personal booking history and cancel bookings.
- **My Profile** — View account details and update password.

---

## OOP Concepts Used

### Inheritance
`User` is an abstract base class. `Manager`, `TicketingClerk`, and `Customer` all extend `User` and inherit common fields (userId, username, password, fullName, email) while adding their own specific fields.

```
User (abstract)
├── Manager         (adds: employeeId)
├── TicketingClerk  (adds: employeeId, assignedCounter)
└── Customer        (adds: phoneNumber, registrationDate)
```

### Interfaces
- `Displayable` — requires `getDisplayInfo()` and `getDetailedInfo()` methods.
- `Saveable` — requires `toFileString()` for converting objects to file-storable strings.

`Movie`, `Showtime`, `Seat`, `Booking`, and `Payment` all implement both interfaces.

### Abstract Classes
`User` is abstract and defines `getDashboardTitle()` as an abstract method. Each subclass provides its own implementation.

### Polymorphism
`AuthService.login()` returns a `User` object. In `LoginFrame`, the returned user is checked with `instanceof` to open the correct dashboard (Manager, Clerk, or Customer).

### Method Overloading
`FileHandler.readLines()` is overloaded — one version reads all lines from a file, and another accepts a filter value and field index to return only matching records.

`User` constructors are overloaded — one takes all fields (for loading from file) and another takes fewer fields (for new registrations).

### Encapsulation
All model fields are `private` with public getters and setters. The `main_logics` service layer handles all business logic, keeping UI classes separate from data access.

### Exception Handling
File I/O operations, login failures, and payment processing all use `try-catch` blocks. Custom error messages are shown to the user in the UI rather than raw exceptions.

### Event Handling
All buttons use `ActionListener` events generated by the NetBeans GUI builder and handled in their respective `*ActionPerformed` methods.

---

## Data Storage

All data is stored in pipe-delimited (`|`) text files inside `src/data/`. One record per line.

### File Formats

**users.txt**
```
userId|username|password|fullName|email|role|[extra fields]
U001|admin|admin123|Admin Manager|admin@cinema.com|MANAGER|EMP001
U002|clerk1|clerk123|John Clerk|john@cinema.com|CLERK|EMP002|Counter 1
```

**movies.txt**
```
movieId|title|genre|durationMinutes|language|rating|description|isActive
```

**showtimes.txt**
```
showtimeId|movieId|hallNumber|date|time|basePrice|totalSeats|availableSeats
```

**seats.txt**
```
seatId|showtimeId|seatNumber|seatType|isBooked
```
Rows A–C are STANDARD seats, rows D–E are PREMIUM seats. Each showtime gets 50 seats (A1–E10).

**bookings.txt**
```
bookingId|customerId|showtimeId|seatNumbers|bookingDate|status|totalAmount|bookedBy
```

**payments.txt**
```
paymentId|bookingId|amount|paymentMethod|paymentDate|status|discountApplied
```

**discounts.txt**
```
discountType|percentage
SENIOR|15
STUDENT|10
CHILD|20
```

---

## Default Accounts

The following accounts are pre-seeded in `users.txt`:

| Username | Password | Role |
|----------|----------|------|
| `admin` | `admin123` | Cinema Manager |
| `clerk1` | `clerk123` | Ticketing Clerk |

New customer accounts can be created from the login screen by clicking **Register as Customer**.

---

## Package Summary

| Package | Purpose |
|---------|---------|
| `main` | Application entry point, sets Nimbus look and feel |
| `main_running` | Data model classes (User, Movie, Showtime, Seat, Booking, Payment) and interfaces |
| `main_logics` | Service classes for file I/O, authentication, movie/showtime/booking/payment logic |
| `ui` | Login and registration screens, shared utility panels |
| `ui.manager` | Manager dashboard and management screens |
| `ui.customer` | Customer dashboard and booking screens |
| `ui.clerk` | Clerk dashboard and booking management screens |
