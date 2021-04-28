# RecyclerViewInfiniteCache

- DummyAdapter.java
```java
public class DummyAdapter extends RecyclerView.Adapter<DummyAdapter.MyHolder> {

    private ArrayList<String> list;
    private ArrayList<DummyAdapter.MyHolder> holders;

    public DummyAdapter(ArrayList<String> list) {
        this.list = new ArrayList<>(list);
        this.holders = new ArrayList<>(list.size());
        initHolders();
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
        initHolders();
    }

    private void initHolders() {
        for (int i = 0; i < list.size(); i++) {
            holders.add(null);
        }
    }

    public ArrayList<MyHolder> getHolders() {
        return holders;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holders.set(position, holder);
    }

    ...

}
```

- MainActivity.java
```java
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private DummyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        iniRV();
    }

    private void iniRV() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(i+1));
        }
        adapter = new DummyAdapter(list);
        binding.rv.setAdapter(adapter);
        binding.rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        binding.rv.hasFixedSize();
//        binding.rv.setItemViewCacheSize(100);
        binding.rv.setItemViewCacheSize(list.size());

        getItemPerIndex();
    }

    private void getItemPerIndex() {
        for (int i = 0; i < adapter.getHolders().size(); i++) {
            DummyAdapter.MyHolder holder = adapter.getHolders().get(i);

            String data = holder.binding.tv.getText().toString();
            Log.d(getClass().getSimpleName(), "getItemPerIndex: "+data);
        }
    }
}
```

---

```
Copyright 2021 M. Fadli Zein
```