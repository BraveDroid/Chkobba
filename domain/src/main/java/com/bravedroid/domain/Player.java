package com.bravedroid.domain;

import java.io.IOException;

public interface Player {

    boolean acceptFirstCard(Card firstCard) throws IOException;
}
