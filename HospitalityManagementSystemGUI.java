package hms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
public class HospitalityManagementSystemGUI {
	private HotelDAO hotelDAO;
	private RoomDAO roomDAO;
	private GuestDAO guestDAO;
	private ReservationDAO reservationDAO;
	public HospitalityManagementSystemGUI() {
		hotelDAO = new HotelDAO();
		roomDAO =new RoomDAO();
		guestDAO = new GuestDAO();
		reservationDAO = new ReservationDAO();
		createAndShowGUI();
	}
	private void createAndShowGUI() {
		JFrame frame = new JFrame("Hotel Reservation System");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(5, 1));
		JButton addHotelButton = new JButton("Add Hotel");
		addHotelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Hotel hotel = new Hotel(1, "Hotel A", "City A");
				hotelDAO.addHotel(hotel);
				JOptionPane.showMessageDialog(frame, "Hotel added successfully.");
			}
		});
		frame.add(addHotelButton);
		JButton addRoomButton = new JButton("Add Room");
		addRoomButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Room room=new Room(1,1,101, "Single", 100.00, "Available");
				roomDAO.addRoom(room);
				JOptionPane.showMessageDialog(frame, "Room added successfully.");
			}
		});
		frame.add(addRoomButton);
		JButton addGuestButton = new JButton("Add Guest");
		addGuestButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Guest guest = new Guest(1, "John Doe", "john@example.com", "1234567890");
				guestDAO.addGuest(guest);
				JOptionPane.showMessageDialog(frame, "Guest added successfully.");
			}
		});
		frame.add(addGuestButton);
		JButton addReservationButton = new JButton("Add Reservation");
		addReservationButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Reservation reservation = new Reservation(1, 1, 1, new Date(), new Date());
				reservationDAO.addReservation(reservation);
				JOptionPane.showMessageDialog(frame, "Reservation added successfully.");
			}
		});
		frame.add(addReservationButton);
		JButton retrieveDataButton = new JButton("Retrieve Data");
		retrieveDataButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Hotel retrievedHotel = hotelDAO.getHotelById(1);
				Room retrievedRoom = roomDAO.getRoomById(1);
				Guest retrievedGuest = guestDAO.getGuestById(1);
				Reservation retrievedReservation = reservationDAO.getReservationById(1);
				String data = "Retrieved Hotel: " + retrievedHotel + "\n" + "Retrieved Room: " + retrievedRoom + "\n" + "Retrieved Guest: " + retrievedGuest + "\n" + "Retrieved Reservation: " + retrievedReservation;
				JOptionPane.showMessageDialog(frame, data);
			}
		});
		frame.add(retrieveDataButton);
		frame.pack();
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new HospitalityManagementSystemGUI();
			}
		});
	}
}