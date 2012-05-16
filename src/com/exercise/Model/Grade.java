package com.exercise.Model;

public class Grade {

		private String initial_time;		
		private String final_time;
		private int day_of_week;
		private int status;
		private int id_network;		
		
		public Grade(String initial_time, String final_time, int day_of_week, int status, int id_network) {
			setInitial_time(initial_time);
			setFinal_time(final_time);
			setDay_of_week(day_of_week);
			setStatus(status);
			setId_network(id_network);								
		}
		
		public String getInitial_time() {
			return initial_time;
		}

		public void setInitial_time(String initial_time) {
			this.initial_time = initial_time;
		}

		public String getFinal_time() {
			return final_time;
		}

		public void setFinal_time(String final_time) {
			this.final_time = final_time;
		}

		public int getDay_of_week() {
			return day_of_week;
		}

		public void setDay_of_week(int day_of_week) {
			this.day_of_week = day_of_week;
		}

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

		public int getId_network() {
			return id_network;
		}

		public void setId_network(int id_network) {
			this.id_network = id_network;
		}
}
