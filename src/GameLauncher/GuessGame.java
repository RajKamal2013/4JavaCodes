class GuessGame {
	Player P1;
	Player P2;
	Player P3;


	public void StartGame() {
		P1 = new Player();
		P2 = new Player();
		P3 = new Player();

		int guess1 = 0;
		int guess2 = 0;
		int guess3 = 0;

		boolean P1isRight = false;
		boolean P2isRight = false;
		boolean P3isRight = false;

		int TargetNumber = (int) (Math.random() * 10);
		System.out.println("I'm thinking of a number between 0 and 9 ");

		while(true) {
			System.out.println("Number to guess is " + TargetNumber);

			P1.guess();
			P2.guess();
			P3.guess();

			guess1 = P1.number;
			System.out.println("Player one Guessed : " + guess1);

			guess2 = P2.number;
			System.out.println("Player two Guessed : " + guess2);

			guess3 = P3.number;
			System.out.println("Player three Guessed : " + guess3);

			if (guess1 == TargetNumber) 
				P1isRight = true;

			if (guess2 == TargetNumber)
				P2isRight = true;

			if (guess3 == TargetNumber)
				P3isRight = true;

			if (P1isRight || P2isRight || P3isRight) {
				System.out.println("We have a winner ");
				System.out.println("Player one got it right ? " + P1isRight);
				System.out.println("Player two got it right ? " + P2isRight);
				System.out.println("Player three got it right ? " + P3isRight);
				System.out.println("Game is over ");
				break;
			} else
				System.out.println("Players have to try again");

		}
	}
}


