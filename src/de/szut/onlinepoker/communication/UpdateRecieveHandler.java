package de.szut.onlinepoker.communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import de.szut.onlinepoker.helper.Event;
import de.szut.onlinepoker.model.Table;
import de.szut.onlinepoker.model.TablePlayer;

public class UpdateRecieveHandler implements Runnable {

	private BufferedReader reader;
	private boolean terminated;
	private JSONObject json;

	public UpdateRecieveHandler(InputStream in) {

		reader = new BufferedReader(new InputStreamReader(in));

	}

	@Override
	public void run() {

		String update = null;

		while (!terminated) {
			try {
				update = reader.readLine();

				// TODO handleUpdate

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			json = JSONObject.fromObject(update);
			Table t = new Table();
			t.potMoney = json.getInt(Event.POT);
			t.tableId = json.getInt(Event.EVENT_TABLEID);
			t.tableName = json.getString(Event.EVENT_TABLENAME);
			JSONArray arr = json.getJSONArray(Event.PLAYER);
			int size = arr.size();
			TablePlayer[] tablePlayer = new TablePlayer[size];
			JSONObject temp;
			for (int i = 0; i < size; i++) {
				temp = JSONObject.fromObject(arr.get(i));
				boolean empty = temp.getBoolean(Event.EMPTYSEAT);
				tablePlayer[i] = null;
				if (!empty) {

					TablePlayer p = new TablePlayer();

					p.fold = temp.getBoolean(Event.ISFOLD);
					p.money = temp.getInt(Event.CHIPS);
					p.name = temp.getString(Event.EVENT_NAME);
					p.betted = temp.getInt(Event.CHIPS_BETTED);
					tablePlayer[i] = p;

				}
			}
		}

	}

	public void stop() {
		terminated = true;
	}

}
