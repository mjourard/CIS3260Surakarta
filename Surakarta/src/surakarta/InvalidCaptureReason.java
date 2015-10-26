/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package surakarta;

/**
 *
 * @author Matt
 */
public enum InvalidCaptureReason {
    NoPieceSelected,
    NoOpponentsPieceSelected,
    OpponentsPieceSelectedWithStartCoordinates,
    FriendlyPieceSelectedWithEndCoordinates,
    CaptureDoesNotInvolveLoop,
    NoLoopSequenceAvailableToReachEndCoordinates,
    HitsOtherPieceBeforeReachingEndCoordinates
}
