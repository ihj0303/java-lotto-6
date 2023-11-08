package lotto.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lotto.domain.Lotto;

public class LottoRepository {
    public static final int LOTTO_PRICE = 1000;
    private static Map<Long, Lotto> lottos = new ConcurrentHashMap<>();
    private static long id = 0L;
    private static int budget;

    private static LottoRepository instance;

    private LottoRepository() {
    }

    public static LottoRepository getInstance() {
        if (instance == null) {
            instance = new LottoRepository();
        }
        return instance;
    }
    public static void setBudget(int budget) {
        LottoRepository.budget = budget;
    }

    public static int getBudget() {
        return budget;
    }

    public static List<Lotto> getLottos() {
        return new ArrayList<>(lottos.values());
    }

    public Lotto save(Lotto lotto) {
        lotto.id = id++;
        lottos.put(lotto.id, lotto);
        return lotto;
    }
}