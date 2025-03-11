# JobOrbit - Job Search and Recruitment Platform

![JobOrbit Screenshot](./images/screenshot1.png)
![JobOrbit Dashboard](./images/screenshot2.png)

## Overview
**JobOrbit** is a job search and recruitment platform that connects job seekers with recruiters. It allows candidates to search for jobs, apply for positions, and manage their profiles. Recruiters can post job listings, manage applications, and find the best talent for their organizations.

## Features

### 🔹 Job Seeker Features
- Search for jobs by keywords and location
- Create and manage a user profile
- Apply for jobs directly from the platform
- Save job listings for later
- Receive job recommendations

### 🔹 Recruiter Features
- Post job openings with detailed descriptions
- Manage job applications from candidates
- Shortlist and contact potential hires
- View analytics on job postings

### 🔹 Admin Features
- Manage users (job seekers & recruiters)
- Approve or reject job postings
- Monitor platform activity

## Tech Stack
- **Frontend:** React.js, Bootstrap
- **Backend:** Spring Boot, Java
- **Database:** MySQL
- **Authentication:** JWT-based authentication
- **Hosting:** Deployed on cloud platforms

## Setup Instructions

### Prerequisites
- Java 17+
- Node.js 16+
- MySQL 8+

### Installation

#### Backend Setup
```sh
git clone https://github.com/yourusername/JobOrbit.git
cd JobOrbit/backend
mvn clean install
mvn spring-boot:run
