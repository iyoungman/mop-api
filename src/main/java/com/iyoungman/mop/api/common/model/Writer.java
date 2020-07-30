package com.iyoungman.mop.api.common.model;

import com.iyoungman.mop.api.domain.board.exception.InvalidWriterException;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by iyoungman on 2020-07-22.
 */

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Writer {

    @Column(name = "member_id")
    private Long writerId;

    @Column(name = "member_name")
    private String writerName;

    public Writer(Long writerId, String writerName) {
        this.writerId = writerId;
        this.writerName = writerName;
    }

    public void checkWriter(Long memberIdByToken) {
        if (!writerId.equals(memberIdByToken)) {
            throw new InvalidWriterException();
        }
    }
}
