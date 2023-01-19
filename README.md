# Mobile-Application-Development-Project

Member:
1. Muhammad Syafiq Firdaus Bin Alang Ahmad (B032010350)
2. Nur Alia Binti Jasmy Hairuddin (B032010209)
3. Dwain Hanlon Matin (B032010243)
4. Nur Aqilah Hannan Binti Azmi (B032010260)

This project is about bowling club registration and booking system. user can register into the club and booking the lane.

1. If want to try login, use this tester account.
gmail = tester@gmail.com
password = 123456

2. Sidebar navigation menu can be found at Guest and Logged In users Interfaces.

3. Multiple Activity(Guest);
- Home
- Announcement
- Merchandise
- Login
- About Us

4. Multiple Activity(User Logged in): 
- Home
- Booking
- Member
- Announcement
- Merchandise
- Promotion
- Setting
- About Us
- Logout

5. We have 2 fragments:
- Aboutus.java under com.example.goldendreamsbowling
- BookingFragment.java under LoggedInUser

6. We put two REST API in this project;
a. Get Current Date Time API (coding are in below location);
- HomePage.java under com.example.goldendreamsbowling 
- MainInterface.java under Guest

b. Maps REST API which to locate the club location (coding are in below location- MapsACtivity.java under goldendreamsbowling)
( The maps button can be found in below;)
- Aboutus.java under com.example.goldendreamsbowling
- About2.java under Guest

7. We use firebase for database connection and use snapshot coding to fetch data. the database object declared is user, booking, announcement, member.
