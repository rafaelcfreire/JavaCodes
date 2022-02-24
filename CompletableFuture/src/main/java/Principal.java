import models.Avatar;
import models.Instance;
import models.Simulation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class Principal {
    private List<Avatar> avatars = new ArrayList<>();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.nanoTime();
        System.out.println("Started with Thread "+Thread.currentThread());
        List<Simulation> first = List.of(new Simulation("sim1"),
                new Simulation("sim2"), new Simulation("sim3"), new Simulation("sim4"),
                new Simulation("sim5"), new Simulation("sim6"));

        List<Instance> firstInstance = List.of(new Instance("instance1", first));
        Avatar avt1 = new Avatar("avatar1", firstInstance);
        System.out.println("Completed "+avt1+" with +"+deleteAvatar(avt1));

        List<Simulation> second = List.of(new Simulation("sim1"),
                new Simulation("sim2"), new Simulation("sim3"), new Simulation("sim4"),
                new Simulation("sim5"), new Simulation("sim6"));

        List<Instance> secondInstance = List.of(new Instance("instance1", second));
        Avatar avt2 = new Avatar("avatar2", secondInstance);
        System.out.println("Completed "+avt2+" with +"+deleteAvatar(avt2));

        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + duration + " msecs");
    }

    static Integer deleteAvatar(Avatar avatar) throws ExecutionException, InterruptedException {
        System.out.println("Starting delete avatar "+avatar.getName());
        var deleteInstances = deleteInstances(avatar.getInstances());
        if(deleteInstances.parallelStream().filter(integer -> !integer.equals(200)).count() > 0)
            throw new RuntimeException();

        CompletableFuture<Integer> deleteAvatar = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return Integer.valueOf(200);
        });
        return deleteAvatar.join();
    }

    static List<Integer> deleteInstances(List<Instance> instances) throws ExecutionException, InterruptedException {
        /*for(Instance instance : instances){
            var result = deleteSimulations(instance.getSimulations());
            if(!Integer.valueOf(200).equals(result.get()))
                throw new RuntimeException();
        }**/

        var deleteSimulats = instances.stream().map(instance -> {
           return deleteSimulations(instance.getSimulations());
        }).collect(Collectors.toList());

        if(deleteSimulats.stream().flatMap(item -> item.stream()).distinct()
                .filter(integer -> !integer.equals(200)).count() > 0){
            throw new RuntimeException();
        }


        System.out.println("Starting delete instances "+Thread.currentThread());

        List<CompletableFuture<Integer>> delete = instances.stream()
                .map(instance -> CompletableFuture.supplyAsync(() -> {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return Integer.valueOf(200);
                })).collect(Collectors.toList());

        return delete.stream().map(CompletableFuture::join).collect(Collectors.toList());

        /*
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Deleting instances with "+Thread.currentThread());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instances.forEach(instance -> instance = null);
            return Integer.valueOf(200);
        });**/
        /*
        CompletableFuture<Integer> deleteInsts = new CompletableFuture<>();
        new Thread(() -> {
            System.out.println("Deleting instances with "+Thread.currentThread());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instances.forEach(instance -> instance = null);
            deleteInsts.complete(200);
        }).start();
        return deleteInsts;**/
    }

    static List<Integer> deleteSimulations(List<Simulation> simulations){
        System.out.println("Starting delete simulations "+Thread.currentThread());
        List<CompletableFuture<Integer>> delete =
                simulations.stream().map(simulation -> CompletableFuture.supplyAsync(() -> {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("simulation thread");
                    return Integer.valueOf(200);
                })).collect(Collectors.toList());

        return delete.stream().map(CompletableFuture::join).collect(Collectors.toList());
    }


    static Future<Integer> deleteSimulations2(List<Simulation> simulations) {
        return null;
        /*
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Deleting simulations with "+Thread.currentThread());
            simulations.stream().map(simulation -> {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                simulation = null;
                return Integer.valueOf(200);
            }).collect(Collectors.toList());
        });**/
        /*
        CompletableFuture<Integer> deleteSims = new CompletableFuture<>();
        new Thread( () -> {
            System.out.println("Deleting simulations with "+Thread.currentThread());
            simulations.forEach(simulation -> {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                simulation = null;
            });
            deleteSims.complete(200);
        }).start();
        return deleteSims; **/
    }
}
