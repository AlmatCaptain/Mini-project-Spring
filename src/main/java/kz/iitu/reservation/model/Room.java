package kz.iitu.reservation.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Room {

    @Id
    private String number;

    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY)
    private List<ReservedRooms> reserves;


}
