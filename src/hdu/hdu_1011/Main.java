package hdu.hdu_1011;

import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static int PROPORTION = 20;
    static int n, m;

    public static void main(String[] args) {
        while (true) {
            n = scanner.nextInt();
            m = scanner.nextInt();

            if (n == -1 && m == -1) {
                break;
            }

            run();
        }

        scanner.close();
    }

    static void run() {
        Room[] rooms = new Room[n + 1];

        int cost, value;
        for (int i = 1; i <= n; i++) {
            cost = scanner.nextInt();
            value = scanner.nextInt();

            cost = cost % PROPORTION == 0 ? cost / PROPORTION : cost / PROPORTION + 1;

            rooms[i] = new Room(i, cost, value);
        }

        int x, y;
        for (int i = 0; i < n - 1; i++) {
            x = scanner.nextInt();
            y = scanner.nextInt();

            rooms[x].connect(rooms[y]);
            rooms[y].connect(rooms[x]);
        }

        rooms[1].build(0);

        Arrays.sort(rooms, 1, n + 1, new Comparator<Room>() {
            @Override
            public int compare(Room r1, Room r2) {
                return r2.deep - r1.deep;
            }
        });

        for (int i = 1; i < n; i++) {
            Room room = rooms[i];
            Room parentRoom = room.parentRoom;

            int roomCost = room.cost == 0 ? 1 : room.cost;
            int parentCost = parentRoom.cost;


            for (int j = m; j >= parentCost + roomCost; j--) {
                for (int k = roomCost; k <= j - parentCost; k++) {
                    parentRoom.cv[j] = Math.max(room.cv[k] + parentRoom.cv[j - k], parentRoom.cv[j]);
                }
            }
        }

        int max = 0;
        for (int i = Math.max(rooms[n].cost, 1); i <= m; i++) {
            max = Math.max(rooms[n].cv[i], max);
        }
        System.out.println(max);
    }

    static class Room {
        int no;
        int cost;
        int value;
        int[] cv;

        Room parentRoom;
        int deep;

        boolean linked;
        List<Room> connectRooms = new ArrayList<>();

        Room(int no, int cost, int value) {
            this.no = no;
            this.cost = cost;
            this.value = value;
            cv = new int[m + 1];

            for (int i = cost; i <= m; i++) {
                cv[i] = value;
            }
        }

        void connect(Room connectRoom) {
            connectRooms.add(connectRoom);
        }

        void build(int deep) {
            this.linked = true;
            this.deep = deep;
            for (Room connectRoom : connectRooms) {
                if (connectRoom.linked) {
                    continue;
                }
                connectRoom.link(this);
                connectRoom.build(deep + 1);
            }
        }

        void link(Room parentRoom) {
            this.parentRoom = parentRoom;
        }


        @Override
        public String toString() {
            return String.format("No=%d Cost=%d Value=%d Deep=%d", no, cost, value, deep);

        }
    }
}
