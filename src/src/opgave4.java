import java.util.ArrayList;

    class Player {
        String name;
        int skillLevel;

        Player(String name, int skillLevel) {
            this.name = name;
            this.skillLevel = skillLevel;
        }

        public String toString() {
            return name + " (skill: " + skillLevel + ")";
        }
    }

    class Team {
        String teamName;
        ArrayList<Player> players;

        public Team(String teamName) {
            this.teamName = teamName;
            this.players = new ArrayList<>();
        }

        void addPlayer(Player p) {
            players.add(p);
            System.out.println(p.name + " added to " + teamName);
        }

        double getAverageSkill() {
            if (players.size() == 0) {
                return 0;
            }

            int totalSkill = 0;
            for (Player p : players) {
                totalSkill = totalSkill + p.skillLevel;
            }
            return (double) totalSkill / players.size();
        }

        void printTeam() {
            System.out.println(" ");
            System.out.println("=== " + teamName + " ===");
            System.out.println("Players:");
            for (Player p : players) {
                System.out.println("- " + p);
            }
            System.out.println("team average skill: " + getAverageSkill());
        }

        void compete(Team opponent) {
            System.out.println(" ");
            System.out.println(teamName + " vs " + opponent.teamName);
            double mySkill = getAverageSkill();
            double opponentSkill = opponent.getAverageSkill();

            System.out.println(teamName + " - average skill: " + mySkill);
            System.out.println(opponent.teamName + " - average skill: " + opponentSkill);

            if (mySkill > opponentSkill) {
                System.out.println(" ");
                System.out.println("* " + teamName + " wins! *");
            } else if (opponentSkill > mySkill) {
                System.out.println(" ");
                System.out.println("* " + opponent.teamName + " wins! *");
            } else {
                System.out.println(" ");
                System.out.println("* Draw! *");
            }
        }
    }

        void main() {
            Team team1 = new Team("Counter Terrorists");
            Team team2 = new Team("Terrorists");

            System.out.println("Team Making:");

            team1.addPlayer(new Player("Josh", 100));
            team1.addPlayer(new Player("Joshua", 85));
            team1.addPlayer(new Player("Josef", 90));

            team2.addPlayer(new Player("Phillip", 50));
            team2.addPlayer(new Player("Peter", 60));
            team2.addPlayer(new Player("Parker", 70));

            team1.printTeam();
            team2.printTeam();

            team1.compete(team2);
        }