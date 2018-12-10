package com.AmebaDevices.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.AmebaDevices.dto.ThingDTO;
import com.AmebaDevices.services.ThingService;

public class SolutionGenerator {
	int i = 0;
	public boolean ottimizzato = true;
	List<Integer> prices;
	List<Integer> a;
	public List<Integer> things;
	int items = 0;
	ThingService ts;

	public SolutionGenerator(ThingService ts) {
		this.ts = ts;
		prices = new ArrayList<>();
		a = new ArrayList<>();
		things = new ArrayList<>();
		a.add(16);
		prices.add(25);
		a.add(8);
		prices.add(15);
		a.add(4);
		prices.add(10);

	}

	public List<ThingDTO> generate(int items) {
		List<ThingDTO> toReturn = new ArrayList<>();
		this.items = items;

		List<Integer> thingsTrovate = cercaThings(items, i, a, prices);

		if (getItems() > 0) {
			thingsTrovate.add(4);
		}
		thingsTrovate.forEach(t -> System.out.println(t));

//		Ottimizziamo
//	
		System.out.println("---------------------------------------------");

		Collections.reverse(thingsTrovate);
		if (thingsTrovate.size() > 1) {
			while (ottimizzato)
				ottimizza(thingsTrovate);
		}
		System.out.println("---------------------------------------------");
		thingsTrovate.forEach(t -> System.out.println(t));

		thingsTrovate.forEach(t -> {
			ThingDTO thing = new ThingDTO(getPrezzo(t), t);
			toReturn.add(ts.create(thing));
			System.out.println("L'iddddddddddddddddddddddddd è "+ toReturn.get(toReturn.size()-1).getId());
		});

		return toReturn;

	}

	public int getItems() {
		return items;
	}

	public void setItems(int items) {
		this.items = items;
	}

	public List<Integer> cercaThings(int items, int i, List<Integer> a, List<Integer> prices) {

		for (; i < a.size(); i++) {
			if (items == 0) {
				return things;
			} else if (a.get(i) <= items) {
				things.add(a.get(i));
				setItems(items -= a.get(i));
				return cercaThings(items, i, a, prices);
			}
		}
		return things;

	}

	public int getPrezzo(int thing) {
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i) == thing)
				return prices.get(i);
		}
		return -1;
	}

	public void ottimizza(List<Integer> thingTrovate) {
		ottimizzato = false;
		for (int i = 0; i < thingTrovate.size(); i++) {
			if((i+1)<thingTrovate.size()) {
			int sommaUscite = thingTrovate.get(i) + thingTrovate.get(i + 1);
			int probabileThing = trovaThing(sommaUscite);
			if (probabileThing == -1)
				return;
			int prezzo1 = getPrezzo(probabileThing);
			int prezzo2 = getPrezzo(thingTrovate.get(i));
			int prezzo3 = getPrezzo(thingTrovate.get(i + 1));
			if (prezzo1 <= prezzo2 + prezzo3) {
				thingTrovate.remove(i);
				thingTrovate.remove(i);
				thingTrovate.add(0, probabileThing);
				// thingTrovate.forEach(t -> System.out.println(t));
				ottimizzato = true;
				break;
			}}

		}

	}

	public int trovaThing(int numUscite) {
		for (int i = a.size() - 1; i >= 0; i--) {
			if (a.get(i) >= numUscite)
				return a.get(i);
		}
		return -1;
	}
}
